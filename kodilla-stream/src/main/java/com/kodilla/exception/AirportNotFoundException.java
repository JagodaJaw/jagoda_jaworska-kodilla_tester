package com.kodilla.exception;

public class AirportNotFoundException extends Exception {
    public AirportNotFoundException() {
        super("Airport not found");
    }
}