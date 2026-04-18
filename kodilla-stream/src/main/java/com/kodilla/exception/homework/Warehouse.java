package com.kodilla.exception.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Warehouse {

    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(Objects.requireNonNull(order, "order cannot be null"));
    }

    public Order getOrder(String number) throws OrderDoesntExistException {
        Objects.requireNonNull(number, "number cannot be null");
        return orders.stream()
                .filter(order -> Objects.equals(order.getNumber(), number))
                .findFirst()
                .orElseThrow(() -> new OrderDoesntExistException(number));
    }
}
