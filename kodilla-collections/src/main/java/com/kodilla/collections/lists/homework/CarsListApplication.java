package com.kodilla.collections.lists.homework;

import com.kodilla.collections.arrays.homework.CarUtils;
import com.kodilla.collections.interfaces.homework.BMW;
import com.kodilla.collections.interfaces.homework.Fiat;
import com.kodilla.collections.interfaces.homework.Porsche;
import com.kodilla.collections.interfaces.homework.Car;

import java.util.ArrayList;

public class CarsListApplication {

    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();

        cars.add(new BMW());
        cars.add(new Fiat());
        cars.add(new Porsche());
        cars.add(new Fiat());

        System.out.println("Lista samochodów:");

        for (Car car : cars) {
            CarUtils.describeCar(car);
        }

        System.out.println("Usuwamy samochód o indeksie 1");
        cars.remove(1);

        Car fiat = new Fiat();
        cars.add(fiat);

        System.out.println("Usuwamy konkretny obiekt");
        cars.remove(fiat);

        System.out.println("Lista po usunięciu:");

        for (Car car : cars) {
            CarUtils.describeCar(car);
        }

        System.out.println("Rozmiar listy: " + cars.size());
    }
}
