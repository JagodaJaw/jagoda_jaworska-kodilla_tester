package com.kodilla.parametrized_tests.homework;

public class InvalidNumbersException extends RuntimeException {

    public InvalidNumbersException() {
        super("Wrong numbers provided");
    }
}
