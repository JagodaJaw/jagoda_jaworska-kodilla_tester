package com.kodilla.spring.basic.spring_configuration.homework;

public class Suv implements Car {

    private boolean headlightsTurnedOn;

    public Suv(boolean headlightsTurnedOn) {
        this.headlightsTurnedOn = headlightsTurnedOn;
    }

    @Override
    public boolean hasHeadlightsTurnedOn() {
        return headlightsTurnedOn;
    }

    @Override
    public String getCarType() {
        return "SUV";
    }
}
