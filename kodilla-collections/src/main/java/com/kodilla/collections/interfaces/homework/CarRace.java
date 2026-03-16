package com.kodilla.collections.interfaces.homework;

public class CarRace {

    public static void doRace(Car car) {

        car.increaseSpeed();
        car.increaseSpeed();
        car.increaseSpeed();

        car.decreaseSpeed();
        car.decreaseSpeed();

        System.out.println("Speed: " + car.getSpeed());
    }

    public static void main(String[] args) {

        Car bmw = new BMW();
        Car fiat = new Fiat();
        Car porsche = new Porsche();

        doRace(bmw);
        doRace(fiat);
        doRace(porsche);
    }
}