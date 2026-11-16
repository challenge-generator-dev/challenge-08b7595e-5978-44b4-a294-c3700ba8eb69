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