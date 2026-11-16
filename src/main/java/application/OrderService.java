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