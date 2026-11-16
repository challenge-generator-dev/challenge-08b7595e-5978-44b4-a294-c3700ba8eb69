# Implementación de un servidor de API REST para gestionar órdenes

El sistema debe proporcionar un servidor de API REST que gestione órdenes. El servidor debe permitir la visualización y filtrado de órdenes. Los clientes externos consumirán esta API para interactuar con el sistema de órdenes.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Panel web para consumir una API REST de ordenes |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 1 semana |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y entregará cada archivo con su ruta.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y entregará cada archivo con su ruta. Guárdalos en la carpeta donde quieras trabajar, respetando las rutas.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no entrega todos los archivos al terminar el análisis, escríbele: "entrégame todos los archivos con su ruta".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición de la API REST

**Objetivo:** Definir las rutas y métodos de la API REST para la gestión de órdenes.

**Tiempo estimado:** 2 días

**Instrucciones:**

- Identificar las operaciones necesarias para la gestión de órdenes (crear, leer, actualizar, eliminar).
- Definir las rutas y métodos HTTP correspondientes para cada operación.
- Establecer los parámetros de entrada y salida para cada ruta.

**Entregable:** Documentación de la API REST con las rutas, métodos y parámetros definidos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera los diferentes estados que una orden puede tener y cómo se deben representar en la API.
- Piensa en los posibles filtros que se pueden aplicar a las órdenes y cómo se deben implementar en la API.

</details>

### Fase 2: Implementación de la lógica de negocio

**Objetivo:** Implementar la lógica de negocio para la gestión de órdenes.

**Tiempo estimado:** 3 días

**Instrucciones:**

- Desarrollar los servicios que implementan la lógica de negocio para cada operación de la API REST.
- Asegurar que la lógica de negocio maneje correctamente los diferentes estados de una orden.
- Implementar la lógica para aplicar filtros a las órdenes.

**Entregable:** Código fuente del servidor de API REST con la lógica de negocio implementada.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo manejar los errores y excepciones que puedan ocurrir durante la ejecución de la lógica de negocio.
- Piensa en cómo optimizar el rendimiento de la lógica de negocio para manejar un gran volumen de órdenes.

</details>

### Fase 3: Pruebas y validación

**Objetivo:** Realizar pruebas y validación de la API REST y la lógica de negocio.

**Tiempo estimado:** 2 días

**Instrucciones:**

- Desarrollar pruebas unitarias y de integración para la API REST y la lógica de negocio.
- Ejecutar las pruebas y validar que la API REST y la lógica de negocio funcionan correctamente.
- Documentar los resultados de las pruebas y cualquier problema encontrado.

**Entregable:** Reporte de pruebas con los resultados y cualquier problema encontrado.

<details>
<summary>Pistas de conocimiento</summary>

- Considera usar herramientas de testing para automatizar las pruebas y asegurar la calidad del código.
- Piensa en cómo simular diferentes escenarios de uso para validar la API REST y la lógica de negocio.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es una API REST y cuál es su propósito en este reto?
- **paraQueSirve**: ¿Para qué sirve la lógica de negocio implementada en este reto?
- **comoSeUsa**: ¿Cómo se usa la API REST para gestionar órdenes en este reto?
- **erroresComunes**: ¿Cuáles son los errores comunes que pueden ocurrir durante la ejecución de la lógica de negocio?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de la API REST y la lógica de negocio en este reto?

## Criterios de Evaluacion

- Definición correcta de las rutas y métodos de la API REST.
- Implementación correcta de la lógica de negocio para la gestión de órdenes.
- Manejo adecuado de errores y excepciones en la lógica de negocio.
- Optimización del rendimiento de la lógica de negocio para manejar un gran volumen de órdenes.
- Realización de pruebas unitarias y de integración para validar la API REST y la lógica de negocio.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT) si no tenes un agente en el IDE. Declara lo mismo que AGENTS.md; los archivos que te devuelva el chat los guardas en esta carpeta respetando las rutas.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
