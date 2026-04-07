package com.example.adaptiveapp;

import  android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;

public class AdaptiveManager implements SensorEventListener {

    // ── Estado adaptativo (clase estática pública) ──────────────────────────
    public static class AdaptiveState {
        public boolean isDarkMode;
        public boolean isHighContrast;
        public boolean isMoving;
        public boolean isIntenseMotion;
        public float   textScaleFactor;
        public float   lux;
        public float   acceleration;
        public String  adaptiveLog;
    }

    // ── Interfaz pública ─────────────────────────────────────────────────────
    public interface AdaptiveListener {
        void onLightChanged(float lux);
        void onMotionChanged(float acceleration);
        void onAdaptiveUpdate(AdaptiveState state);   // <-- usa AdaptiveState directamente
    }

    // Umbrales
    private static final float LUX_DARK_THRESHOLD      = 20f;
    private static final float LUX_BRIGHT_THRESHOLD    = 5000f;
    private static final float MOTION_THRESHOLD        = 3.0f;
    private static final float INTENSE_MOTION_THRESHOLD = 8.0f;

    private final SensorManager   sensorManager;
    private final Sensor          lightSensor;
    private final Sensor          accelerometer;
    private final AdaptiveListener listener;
    private final Handler         handler = new Handler(Looper.getMainLooper());

    private float currentLux   = 200f;
    private float currentAccel = 0f;
    private long  lastUpdateTime = 0;

    public AdaptiveManager(Context context, AdaptiveListener listener) {
        this.listener   = listener;
        sensorManager   = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        lightSensor     = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        accelerometer   = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void start() {
        if (lightSensor != null)
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        if (accelerometer != null)
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void stop() {
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            currentLux = event.values[0];
            listener.onLightChanged(currentLux);

        } else if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            float magnitude = (float) Math.sqrt(x * x + y * y + z * z);
            currentAccel = Math.abs(magnitude - SensorManager.GRAVITY_EARTH);
            listener.onMotionChanged(currentAccel);
        }

        long now = System.currentTimeMillis();
        if (now - lastUpdateTime > 500) {
            lastUpdateTime = now;
            handler.post(this::computeAdaptiveState);
        }
    }

    private void computeAdaptiveState() {
        AdaptiveState state     = new AdaptiveState();
        state.lux               = currentLux;
        state.acceleration      = currentAccel;
        state.isDarkMode        = currentLux < LUX_DARK_THRESHOLD;
        state.isHighContrast    = currentLux > LUX_BRIGHT_THRESHOLD;
        state.isMoving          = currentAccel > MOTION_THRESHOLD;
        state.isIntenseMotion   = currentAccel > INTENSE_MOTION_THRESHOLD;

        if (currentLux < LUX_DARK_THRESHOLD) {
            state.textScaleFactor = 1.6f;
        } else if (state.isMoving) {
            state.textScaleFactor = 1.4f;
        } else {
            state.textScaleFactor = 1.0f;
        }

        StringBuilder log = new StringBuilder();
        log.append("💡 Luz: ").append(String.format("%.1f", currentLux)).append(" lux\n");
        log.append("📡 Movimiento: ").append(String.format("%.2f", currentAccel)).append(" m/s²\n");
        log.append("🎨 Tema: ").append(state.isDarkMode ? "OSCURO" : "CLARO").append("\n");
        log.append("🔤 Texto: x").append(state.textScaleFactor).append("\n");
        log.append("⚡ Contraste alto: ").append(state.isHighContrast ? "SÍ" : "NO").append("\n");
        log.append("🏃 En movimiento: ").append(state.isMoving ? "SÍ" : "NO").append("\n");
        log.append("🚨 Movimiento intenso: ").append(state.isIntenseMotion ? "SÍ" : "NO");
        state.adaptiveLog = log.toString();

        listener.onAdaptiveUpdate(state);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) { /* no-op */ }
}