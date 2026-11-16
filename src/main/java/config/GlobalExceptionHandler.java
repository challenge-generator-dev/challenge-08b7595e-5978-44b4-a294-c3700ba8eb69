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