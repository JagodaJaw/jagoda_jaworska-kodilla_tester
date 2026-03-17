package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.*;

import java.util.Random;
import java.util.Random;
import com.kodilla.collections.interfaces.homework.*;
public class CarsApplication {



    public static Car drawCar() {

        Random random = new Random();

        int carType = random.nextInt(3);
        Car car;

        if (carType == 0) {
            car = new BMW();
        } else if (carType == 1) {
            car = new Fiat();
        } else {
            car = new Porsche();
        }

        int speedIncrease = random.nextInt(10) + 1;

        for (int i = 0; i < speedIncrease; i++) {
            car.increaseSpeed();
        }

        return car;
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