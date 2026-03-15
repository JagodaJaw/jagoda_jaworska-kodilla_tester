package com.kodilla.collections.interfaces.homework;

public class CarRace {

    public static void doRace(Car car) {

        car.increaseSpeed();
        car.increaseSpeed();
        car.increaseSpeed();

        car.decreaseSpeed();
        car.decreaseSpeed();

        System.out.println(car.getSpeed());
    }

    public static void main(String[] args) {

        BMW bmw = new BMW();
        Fiat fiat = new Fiat();
        Porsche porsche = new Porsche();

        doRace(bmw);
        doRace(fiat);
        doRace(porsche);
    }
}