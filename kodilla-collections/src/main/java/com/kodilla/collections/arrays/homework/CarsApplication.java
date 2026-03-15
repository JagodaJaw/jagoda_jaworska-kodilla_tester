package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.*;

import java.util.Random;

public class CarsApplication {

    public static Car drawCar() {

        Random random = new Random();
        int drawnCarKind = random.nextInt(3);

        if (drawnCarKind == 0)
            return new BMW();

        else if (drawnCarKind == 1)
            return new Fiat();

        else
            return new Porsche();
    }

    public static void main(String[] args) {

        Random random = new Random();

        int carsNumber = random.nextInt(15) + 1;

        Car[] cars = new Car[carsNumber];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = drawCar();
        }

        for (int i = 0; i < cars.length; i++) {
            CarUtils.describeCar(cars[i]);
        }
    }
}