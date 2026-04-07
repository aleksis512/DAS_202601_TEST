# AdaptiveApp

AdaptiveApp es una aplicación móvil desarrollada en Android que demuestra cómo una interfaz de usuario puede **adaptarse automáticamente al contexto del entorno** utilizando sensores del dispositivo. La app detecta condiciones como la iluminación ambiental y el movimiento del usuario para modificar su comportamiento visual en tiempo real.

## Descripción

El propósito de esta aplicación es mostrar cómo un sistema adaptativo puede mejorar la **usabilidad**, la **accesibilidad** y la **seguridad** del usuario mediante cambios automáticos en la interfaz.

A diferencia de una aplicación tradicional con una interfaz fija, AdaptiveApp responde al contexto detectado por el dispositivo y aplica ajustes dinámicos según las condiciones del entorno.

## Objetivo

El objetivo principal de AdaptiveApp es implementar un prototipo funcional de **software adaptativo en Android**, capaz de reaccionar ante estímulos físicos del entorno y ajustar la experiencia de usuario en consecuencia.

## Funcionalidades principales

La aplicación utiliza los sensores del dispositivo para detectar cambios en el entorno y aplicar adaptaciones automáticas como:

- Activación de **modo oscuro** en ambientes con poca luz.
- Activación de **alto contraste** cuando existe una exposición elevada a la luz.
- Ajuste dinámico del **tamaño del texto** para mejorar la legibilidad.
- Detección de **movimiento** y **movimiento intenso** mediante el acelerómetro.
- Visualización de una **alerta de seguridad** cuando el usuario se encuentra en movimiento intenso.
- Activación de un **modo simplificado** que reduce elementos visuales innecesarios en situaciones de movimiento.
- Registro de un **log adaptativo en tiempo real** con el estado actual del sistema.

## Sensores utilizados

AdaptiveApp se basa en dos sensores principales del dispositivo móvil:

- **Sensor de luz**: permite medir la iluminación del entorno.
- **Acelerómetro**: permite detectar el nivel de movimiento del dispositivo.

## Arquitectura general

La aplicación está compuesta principalmente por dos clases:

### `AdaptiveManager`
Se encarga de:

- Escuchar los sensores del dispositivo.
- Procesar los valores de luz y aceleración.
- Calcular el estado adaptativo del sistema.
- Notificar los cambios a la interfaz.

### `MainActivity`
Se encarga de:

- Construir la interfaz de usuario.
- Recibir el estado adaptativo calculado.
- Aplicar visualmente las adaptaciones en tiempo real.

## Propósito académico

Este proyecto fue desarrollado con fines académicos para demostrar la aplicación de conceptos relacionados con:

- **Software adaptativo**
- **Interfaces contextuales**
- **Accesibilidad dinámica**
- **Sensores en dispositivos móviles**
- **Diseño centrado en el usuario**

## Tecnologías utilizadas

- **Java**
- **Android Studio**
- **Android SDK**
- **SensorManager**
- **AppCompat**
- **CardView**

## Caso de uso

AdaptiveApp puede servir como base conceptual para aplicaciones orientadas a:

- Movilidad inteligente
- Seguridad en el uso del dispositivo
- Interfaces accesibles
- Aplicaciones contextuales
- Sistemas de asistencia móvil

## Estado del proyecto

Proyecto académico funcional orientado a la exploración de adaptación dinámica de interfaces mediante sensores en Android.

## Autor

Desarrollado como parte de un proyecto académico de software adaptativo.
