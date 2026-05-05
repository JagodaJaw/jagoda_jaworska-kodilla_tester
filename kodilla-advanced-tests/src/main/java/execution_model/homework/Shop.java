package execution_model.homework;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Shop {

    private final Set<Order> orders = new HashSet<>();

    public void addOrder(Order order) {
        this.orders.add(Objects.requireNonNull(order));
    }

    public List<Order> getOrdersFromDateRange(LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(startDate);
        Objects.requireNonNull(endDate);
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        return this.orders.stream()
                .filter(order -> !order.getDate().isBefore(startDate))
                .filter(order -> !order.getDate().isAfter(endDate))
                .collect(Collectors.toList());
    }

    public List<Order> getOrdersFromValueRange(double minValue, double maxValue) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException("Minimum value cannot be greater than maximum value");
        }
        return this.orders.stream()
                .filter(order -> order.getValue() >= minValue)
                .filter(order -> order.getValue() <= maxValue)
                .collect(Collectors.toList());
    }

    public int getNumberOfOrders() {
        return this.orders.size();
    }

    public double getTotalValue() {
        return this.orders.stream()
                .mapToDouble(Order::getValue)
                .sum();
    }
}
