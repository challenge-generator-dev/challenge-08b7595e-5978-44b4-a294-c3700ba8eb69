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