AdaptiveApp
AdaptiveApp es una aplicación Android orientada a demostrar cómo una interfaz de usuario puede adaptarse automáticamente al contexto del entorno utilizando los sensores del dispositivo. La app detecta condiciones como baja iluminación, alta exposición a luz, movimiento o movimiento intenso, y en función de ello modifica la presentación visual para mejorar la experiencia de uso.

¿Para qué sirve?
El objetivo principal de la aplicación es mostrar cómo un sistema móvil puede implementar adaptación en tiempo real para aumentar la usabilidad, accesibilidad y seguridad del usuario. En lugar de mantener una interfaz fija, la aplicación responde al contexto detectado por el dispositivo y ajusta su comportamiento automáticamente.

¿Qué hace la aplicación?
AdaptiveApp utiliza dos sensores principales del teléfono:

Sensor de luz: mide la iluminación del entorno.

Acelerómetro: detecta el nivel de movimiento del dispositivo.

Con base en esos datos, la app realiza adaptaciones como:

Activar modo oscuro en ambientes con poca luz.

Activar alto contraste cuando hay demasiada iluminación.

Aumentar el tamaño del texto para mejorar la legibilidad.

Mostrar una alerta de seguridad cuando detecta movimiento intenso.

Ocultar partes secundarias de la interfaz y activar un modo simplificado cuando el usuario está en movimiento.

Mostrar un log adaptativo en tiempo real con el estado actual del sistema.

Propósito del proyecto
Este proyecto fue desarrollado como una demostración práctica de software adaptativo en Android, aplicando principios de:

Interfaces contextuales.

Computación adaptativa.

Accesibilidad dinámica.

Uso de sensores móviles.

Diseño centrado en el usuario.

Arquitectura general
La aplicación se compone principalmente de dos clases:

AdaptiveManager: se encarga de leer los sensores, procesar los datos y calcular el estado adaptativo.

MainActivity: construye la interfaz y aplica visualmente las adaptaciones calculadas.

De esta forma, la lógica de adaptación se mantiene separada de la lógica de presentación, facilitando el mantenimiento y la escalabilidad del código.

Tecnologías usadas
Java

Android SDK

SensorManager

AppCompat

CardView

UI construida programáticamente

Caso de uso
AdaptiveApp puede entenderse como un prototipo de aplicación inteligente capaz de ajustarse automáticamente al contexto de uso del usuario. Este enfoque puede aplicarse en escenarios como:

Apps de movilidad.

Sistemas de asistencia al conductor.

Aplicaciones accesibles para usuarios con necesidades visuales.

Interfaces seguras para uso en movimiento.
