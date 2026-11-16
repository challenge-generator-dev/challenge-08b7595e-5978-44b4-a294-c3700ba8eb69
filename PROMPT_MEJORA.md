# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/application/OrderService.java` — La fase "Definición de la API REST" se implementa aqui: este archivo es el ejercicio.
- `src/main/java/config/GlobalExceptionHandler.java` — La fase "Implementación de la lógica de negocio" se implementa aqui: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.getId`: Se invoca `getId` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.setId`: Se invoca `setId` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.setCustomerId`: Se invoca `setCustomerId` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.getCustomerId`: Se invoca `getCustomerId` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.setStatus`: Se invoca `setStatus` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.getStatus`: Se invoca `getStatus` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.setCreatedAt`: Se invoca `setCreatedAt` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.getCreatedAt`: Se invoca `getCreatedAt` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.setUpdatedAt`: Se invoca `setUpdatedAt` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.getUpdatedAt`: Se invoca `getUpdatedAt` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.getItems`: Se invoca `getItems` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderItemEntity.setProductId`: Se invoca `setProductId` sobre `OrderItemEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderItemEntity.setQuantity`: Se invoca `setQuantity` sobre `OrderItemEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderItemEntity.setPrice`: Se invoca `setPrice` sobre `OrderItemEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderItemEntity.setOrder`: Se invoca `setOrder` sobre `OrderItemEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.setItems`: Se invoca `setItems` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/infrastructure/OrderRepositoryImpl.java` — `OrderEntity.updateStatus`: Se invoca `updateStatus` sobre `OrderEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior L2

### Brecha de conocimiento
Construir un panel web en React que consuma la API REST de ordenes, Construye una interfaz web en React que consume la API REST de ordenes con manejo de estado y errores

### Misión / candidato
Visualizar y filtrar ordenes

### Reto
- Tema: Panel web para consumir una API REST de ordenes
- Seniority: senior-l2
- Tipo: practical
- Título: Implementación de un servidor de API REST para gestionar órdenes
- Tiempo estimado: 1 semana

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición de la API REST — objetivo: Definir las rutas y métodos de la API REST para la gestión de órdenes. — entregable (NO resolver): Documentación de la API REST con las rutas, métodos y parámetros definidos.
- Fase 2: Implementación de la lógica de negocio — objetivo: Implementar la lógica de negocio para la gestión de órdenes. — entregable (NO resolver): Código fuente del servidor de API REST con la lógica de negocio implementada.
- Fase 3: Pruebas y validación — objetivo: Realizar pruebas y validación de la API REST y la lógica de negocio. — entregable (NO resolver): Reporte de pruebas con los resultados y cualquier problema encontrado.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>
        <dependency>
            <groupId>jakarta.validation</groupId>
            <artifactId>jakarta.validation-api</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.10.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/domain/Order.java ===
package domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private String customerId;
    private List<OrderItem> items;
    private OrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order(String customerId, List<OrderItem> items) {
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.items = items;
        this.status = OrderStatus.PENDING;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    public static class OrderItem {
        private String productId;
        private int quantity;
        private double price;

        public OrderItem(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }

        public String getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }
    }

    public enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED,
        CANCELLED
    }
}

// === ARCHIVO: src/main/java/domain/OrderRepository.java ===
package domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(String id);
    List<Order> findAll();
    List<Order> findByCustomerId(String customerId);
    List<Order> findByStatus(Order.OrderStatus status);
    List<Order> findByDateRange(LocalDateTime fromDate, LocalDateTime toDate);
    List<Order> filterOrders(Order.OrderStatus status, String customerId, LocalDateTime fromDate, LocalDateTime toDate);
    void deleteById(String id);
}

// === ARCHIVO: src/main/java/infrastructure/dto/OrderDto.java ===
package infrastructure.dto;

import domain.Order;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record OrderDto(
        @NotBlank(message = "Customer ID is required")
        String customerId,

        @NotEmpty(message = "Order must have at least one item")
        List<OrderItemDto> items,

        Order.OrderStatus status
) {
    public record OrderItemDto(
            @NotBlank(message = "Product ID is required")
            String productId,

            @Positive(message = "Quantity must be positive")
            int quantity,

            @Positive(message = "Price must be positive")
            double price
    ) {}

    public Order toDomain() {
        List<Order.OrderItem> orderItems = items.stream()
                .map(item -> new Order.OrderItem(item.productId(), item.quantity(), item.price()))
                .toList();

        Order order = new Order(customerId, orderItems);
        if (status != null) {
            order.updateStatus(status);
        }
        return order;
    }
}

// === ARCHIVO: src/main/java/application/OrderService.java ===
package application;

import domain.Order;
import domain.OrderRepository;
import infrastructure.dto.OrderDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderDto orderDto) {
        // TODO(reto): Implementar la lógica para crear una orden
        // Convertir OrderDto a Order usando el método toDomain()
        // Guardar la orden en el repositorio
        // Retornar la orden creada
        return null;
    }

    public Optional<Order> getOrderById(String id) {
        // TODO(reto): Implementar la lógica para obtener una orden por ID
        // Buscar la orden en el repositorio por su ID
        // Retornar el Optional con la orden si existe
        return null;
    }

    public List<Order> getAllOrders() {
        // TODO(reto): Implementar la lógica para obtener todas las órdenes
        // Obtener todas las órdenes del repositorio
        // Retornar la lista de órdenes
        return null;
    }

    public Order updateOrder(String id, OrderDto orderDto) {
        // TODO(reto): Implementar la lógica para actualizar una orden
        // Buscar la orden existente por ID
        // Si no existe, lanzar una excepción
        // Actualizar los datos de la orden con los del DTO
        // Guardar la orden actualizada
        // Retornar la orden actualizada
        return null;
    }

    public void deleteOrder(String id) {
        // TODO(reto): Implementar la lógica para eliminar una orden
        // Eliminar la orden del repositorio por su ID
    }

    public List<Order> filterOrders(Order.OrderStatus status, String customerId,
                                     String fromDate, String toDate) {
        // TODO(reto): Implementar la lógica para filtrar órdenes
        // Convertir las fechas de String a LocalDateTime
        // Llamar al método filterOrders del repositorio
        // Retornar la lista de órdenes filtradas
        return null;
    }
}

// === ARCHIVO: src/main/java/config/GlobalExceptionHandler.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        // TODO(reto): Implementar manejo de errores de validación
        // Recorrer los errores de validación
        // Crear un mapa con los errores encontrados
        // Retornar ResponseEntity con estado BAD_REQUEST y el mapa de errores
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
          throw new UnsupportedOperationException("TODO(reto): getBindingResult");
        });
        Map<String, Object> response = new HashMap<>();
        response.put("errors", errors);
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(
            IllegalArgumentException ex) {
        // TODO(reto): Implementar manejo de IllegalArgumentException
        // Crear un mapa con el mensaje de error
        // Retornar ResponseEntity con estado BAD_REQUEST
        Map<String, Object> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        // TODO(reto): Implementar manejo genérico de excepciones
        // Crear un mapa con los detalles del error
        // Incluir timestamp, mensaje y tipo de excepción
        // Retornar ResponseEntity con estado INTERNAL_SERVER_ERROR
        Map<String, Object> response = new HashMap<>();
        response.put("message", ex.getMessage());
        response.put("type", ex.getClass().getSimpleName());
        response.put("timestamp", LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: order-api
  datasource:
    url: jdbc:h2:mem:orderdb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.H2Dialect

server:
  port: 8080

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
  endpoint:
    health:
      show-details: when-authorized

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    enabled: true

logging:
  level:
    root: INFO
    com.example: DEBUG
    org.springframework.web: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE

// === ARCHIVO: src/main/java/resources/application.yml ===
spring:
  application:
    name: reto
  datasource:
    url: jdbc:h2:mem:ordersdb
    driver-class-name: org.h2.Driver
    username: sa
    password: 
  h2:
    console:
      enabled: true
      path: /h2-console
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.H2Dialect
        format_sql: true
  jackson:
    serialization:
      write-dates-as-timestamps: false
    default-property-inclusion: non_null

server:
  port: 8080

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
  endpoint:
    health:
      show-details: always

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    enabled: true

logging:
  level:
    root: INFO
    com.example: DEBUG
    org.springframework.web: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"

// === ARCHIVO: src/main/java/infrastructure/OrderRepositoryImpl.java ===
package infrastructure;

import domain.Order;
import domain.OrderRepository;
import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order save(Order order) {
        if (order.getId() == null || order.getId().isEmpty()) {
            OrderEntity entity = toEntity(order);
            entityManager.persist(entity);
            return toDomain(entity);
        } else {
            OrderEntity entity = toEntity(order);
            entity = entityManager.merge(entity);
            return toDomain(entity);
        }
    }

    @Override
    public Optional<Order> findById(String id) {
        OrderEntity entity = entityManager.find(OrderEntity.class, id);
        return Optional.ofNullable(entity).map(this::toDomain);
    }

    @Override
    public List<Order> findAll() {
        TypedQuery<OrderEntity> query = entityManager.createQuery(
                "SELECT o FROM OrderEntity o", OrderEntity.class);
        return query.getResultList().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> findByCustomerId(String customerId) {
        TypedQuery<OrderEntity> query = entityManager.createQuery(
                "SELECT o FROM OrderEntity o WHERE o.customerId = :customerId",
                OrderEntity.class);
        query.setParameter("customerId", customerId);
        return query.getResultList().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> findByStatus(Order.OrderStatus status) {
        TypedQuery<OrderEntity> query = entityManager.createQuery(
                "SELECT o FROM OrderEntity o WHERE o.status = :status",
                OrderEntity.class);
        query.setParameter("status", status.name());
        return query.getResultList().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> findByDateRange(LocalDateTime fromDate, LocalDateTime toDate) {
        TypedQuery<OrderEntity> query = entityManager.createQuery(
                "SELECT o FROM OrderEntity o WHERE o.createdAt BETWEEN :fromDate AND :toDate",
                OrderEntity.class);
        query.setParameter("fromDate", fromDate);
        query.setParameter("toDate", toDate);
        return query.getResultList().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> filterOrders(Order.OrderStatus status, String customerId,
                                     LocalDateTime fromDate, LocalDateTime toDate) {
        StringBuilder jpql = new StringBuilder("SELECT o FROM OrderEntity o WHERE 1=1");
        
        if (status != null) {
            jpql.append(" AND o.status = :status");
        }
        if (customerId != null && !customerId.isEmpty()) {
            jpql.append(" AND o.customerId = :customerId");
        }
        if (fromDate != null) {
            jpql.append(" AND o.createdAt >= :fromDate");
        }
        if (toDate != null) {
            jpql.append(" AND o.createdAt <= :toDate");
        }

        TypedQuery<OrderEntity> query = entityManager.createQuery(jpql.toString(), OrderEntity.class);

        if (status != null) {
            query.setParameter("status", status.name());
        }
        if (customerId != null && !customerId.isEmpty()) {
            query.setParameter("customerId", customerId);
        }
        if (fromDate != null) {
            query.setParameter("fromDate", fromDate);
        }
        if (toDate != null) {
            query.setParameter("toDate", toDate);
        }

        return query.getResultList().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        OrderEntity entity = entityManager.find(OrderEntity.class, id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    private OrderEntity toEntity(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setId(order.getId());
        entity.setCustomerId(order.getCustomerId());
        entity.setStatus(order.getStatus().name());
        entity.setCreatedAt(order.getCreatedAt());
        entity.setUpdatedAt(order.getUpdatedAt());

        List<OrderItemEntity> items = order.getItems().stream()
                .map(item -> {
                    OrderItemEntity itemEntity = new OrderItemEntity();
                    itemEntity.setProductId(item.getProductId());
                    itemEntity.setQuantity(item.getQuantity());
                    itemEntity.setPrice(item.getPrice());
                    itemEntity.setOrder(entity);
                    return itemEntity;
                })
                .collect(Collectors.toList());

        entity.setItems(items);
        return entity;
    }

    private Order toDomain(OrderEntity entity) {
        List<Order.OrderItem> items = entity.getItems().stream()
                .map(item -> new Order.OrderItem(
                        item.getProductId(),
                        item.getQuantity(),
                        item.getPrice()))
                .collect(Collectors.toList());

        Order order = new Order(entity.getCustomerId(), items);
        
        try {
            java.lang.reflect.Field idField = Order.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(order, entity.getId());
        } catch (Exception e) {
            // Ignore reflection issues
        }

        order.updateStatus(Order.OrderStatus.valueOf(entity.getStatus()));
        
        try {
            java.lang.reflect.Field createdAtField = Order.class.getDeclaredField("createdAt");
            createdAtField.setAccessible(true);
            createdAtField.set(order, entity.getCreatedAt());
            
            java.lang.reflect.Field updatedAtField = Order.class.getDeclaredField("updatedAt");
            updatedAtField.setAccessible(true);
            updatedAtField.set(order, entity.getUpdatedAt());
        } catch (Exception e) {
            // Ignore reflection issues
        }

        return order;
    }

    @Entity
    @Table(name = "orders")
    public static class OrderEntity {
        @Id
        private String id;

        @Column(name = "customer_id", nullable = false)
        private String customerId;

        @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<OrderItemEntity> items;

        @Column(nullable = false)
        private String status;

        @Column(name = "created_at", nullable = false)
        private LocalDateTime createdAt;

        @Column(name = "updated_at", nullable = false)
        private LocalDateTime updatedAt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public List<OrderItemEntity> getItems() {
            return items;
        }

        public void setItems(List<OrderItemEntity> items) {
            this.items = items;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }
    }

    @Entity
    public static class OrderItemEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "product_id", nullable = false)
        private String productId;

        @Column(nullable = false)
        private int quantity;

        @Column(nullable = false)
        private double price;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "order_id")
        private OrderEntity order;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public OrderEntity getOrder() {
            return order;
        }

        public void setOrder(OrderEntity order) {
            this.order = order;
        }
    }
}

// === ARCHIVO: src/main/java/OrderApplication.java ===
package com.example.reto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.example.reto",
        "application",
        "domain",
        "infrastructure",
        "config",
        "infrastructure.dto"
})
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
```
