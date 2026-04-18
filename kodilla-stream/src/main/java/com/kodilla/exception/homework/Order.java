package com.kodilla.exception.homework;

import java.util.Objects;

public class Order {

    private final String number;

    public Order(String number) {
        this.number = Objects.requireNonNull(number, "number cannot be null");
    }

    public String getNumber() {
        return number;
    }
}
