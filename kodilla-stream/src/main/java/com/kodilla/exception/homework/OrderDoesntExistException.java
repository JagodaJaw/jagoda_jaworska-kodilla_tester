package com.kodilla.exception.homework;

public class OrderDoesntExistException extends Exception {
    public OrderDoesntExistException(String number) {
        super("Order with number " + number + " does not exist");
    }
}
