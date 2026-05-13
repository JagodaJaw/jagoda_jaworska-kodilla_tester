package com.kodilla.spring.basic.spring_configuration.homework;

public class Sedan extends AbstractCar {

    public Sedan(boolean headlightsTurnedOn) {
        super(headlightsTurnedOn);
    }

    @Override
    public String getCarType() {
        return "Sedan";
    }
}
