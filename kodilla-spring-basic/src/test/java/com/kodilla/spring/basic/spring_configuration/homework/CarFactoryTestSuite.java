package com.kodilla.spring.basic.spring_configuration.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CarFactoryTestSuite {

    @Test
    public void shouldCreateCarBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_configuration.homework");
        Car car = context.getBean(Car.class);
        List<String> possibleCarTypes = Arrays.asList("SUV", "Cabrio", "Sedan");
        Assertions.assertTrue(possibleCarTypes.contains(car.getCarType()));
    }

    @Test
    public void shouldReturnSuvInWinter() {
        CarFactory factory = new CarFactory();
        Car car = factory.chooseCar(LocalDateTime.of(2026, 1, 15, 12, 0));
        Assertions.assertEquals("SUV", car.getCarType());
    }

    @Test
    public void shouldReturnCabrioInSummer() {
        CarFactory factory = new CarFactory();
        Car car = factory.chooseCar(LocalDateTime.of(2026, 7, 15, 12, 0));
        Assertions.assertEquals("Cabrio", car.getCarType());
    }

    @Test
    public void shouldReturnSedanInSpringAndAutumn() {
        CarFactory factory = new CarFactory();
        Car springCar = factory.chooseCar(LocalDateTime.of(2026, 4, 15, 12, 0));
        Car autumnCar = factory.chooseCar(LocalDateTime.of(2026, 10, 15, 12, 0));
        Assertions.assertEquals("Sedan", springCar.getCarType());
        Assertions.assertEquals("Sedan", autumnCar.getCarType());
    }

    @Test
    public void shouldTurnHeadlightsOnFromEightPmUntilSixAm() {
        CarFactory factory = new CarFactory();
        Car carAtEightPm = factory.chooseCar(LocalDateTime.of(2026, 7, 15, 20, 0));
        Car carBeforeSixAm = factory.chooseCar(LocalDateTime.of(2026, 7, 15, 5, 59));
        Assertions.assertTrue(carAtEightPm.hasHeadlightsTurnedOn());
        Assertions.assertTrue(carBeforeSixAm.hasHeadlightsTurnedOn());
    }

    @Test
    public void shouldTurnHeadlightsOffAtSixAm() {
        CarFactory factory = new CarFactory();
        Car carAtSixAm = factory.chooseCar(LocalDateTime.of(2026, 7, 15, 6, 0));
        Car carBeforeEightPm = factory.chooseCar(LocalDateTime.of(2026, 7, 15, 19, 59));
        Assertions.assertFalse(carAtSixAm.hasHeadlightsTurnedOn());
        Assertions.assertFalse(carBeforeEightPm.hasHeadlightsTurnedOn());
    }
}
