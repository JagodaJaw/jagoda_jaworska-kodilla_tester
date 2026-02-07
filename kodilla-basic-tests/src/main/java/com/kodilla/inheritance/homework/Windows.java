package com.kodilla.inheritance.homework;

public class Windows extends OperatingSystem {

    public Windows(int releaseYear) {
        super(releaseYear);
        System.out.println("Windows constructor");
    }

    @Override
    public void turnOn() {
        System.out.println("Windows is starting");
    }

    @Override
    public void turnOff() {
        System.out.println("Windows is shutting down");
    }
}