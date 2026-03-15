package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;

public class CarUtils {

    public static void describeCar(Car car) {

        System.out.println("Car type: " + car.getClass().getSimpleName());
        System.out.println("Speed: " + car.getSpeed());
        System.out.println();
    }
}
