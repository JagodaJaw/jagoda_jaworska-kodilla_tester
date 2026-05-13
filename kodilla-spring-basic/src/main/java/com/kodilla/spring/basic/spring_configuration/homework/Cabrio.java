package com.kodilla.spring.basic.spring_configuration.homework;

public class Cabrio extends AbstractCar {

    public Cabrio(boolean headlightsTurnedOn) {
        super(headlightsTurnedOn);
    }

    @Override
    public String getCarType() {
        return "Cabrio";
    }
}
