package com.kodilla.spring.basic.spring_configuration.homework;

public class Suv extends AbstractCar {

    public Suv(boolean headlightsTurnedOn) {
        super(headlightsTurnedOn);
    }

    @Override
    public String getCarType() {
        return "SUV";
    }
}
