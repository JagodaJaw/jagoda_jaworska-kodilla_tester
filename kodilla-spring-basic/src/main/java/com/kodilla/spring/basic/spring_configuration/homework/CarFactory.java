package com.kodilla.spring.basic.spring_configuration.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class CarFactory {

    @Bean
    public Car chosenCar() {
        return chooseCar(LocalDateTime.now());
    }

    public Car chooseCar(LocalDateTime dateTime) {
        boolean headlightsTurnedOn = shouldTurnHeadlightsOn(dateTime.toLocalTime());
        int month = dateTime.getMonthValue();

        if (month == 12 || month == 1 || month == 2) {
            return new Suv(headlightsTurnedOn);
        }
        if (month >= 6 && month <= 8) {
            return new Cabrio(headlightsTurnedOn);
        }
        return new Sedan(headlightsTurnedOn);
    }

    private boolean shouldTurnHeadlightsOn(LocalTime time) {
        return !time.isBefore(LocalTime.of(20, 0)) || time.isBefore(LocalTime.of(6, 0));
    }
}
