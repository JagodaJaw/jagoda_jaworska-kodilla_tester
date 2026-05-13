package com.kodilla.spring.basic.spring_configuration.homework;

public abstract class AbstractCar implements Car {

    private final boolean headlightsTurnedOn;

    protected AbstractCar(boolean headlightsTurnedOn) {
        this.headlightsTurnedOn = headlightsTurnedOn;
    }

    @Override
    public boolean hasHeadlightsTurnedOn() {
        return headlightsTurnedOn;
    }
}
