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