package com.kodilla.collections.adv.exercises.homework;

import java.util.ArrayList;
import java.util.List;

public class FlightRepository {

    private static final List<Flight> flights = new ArrayList<>();

    static {
        flights.add(new Flight("Warsaw", "London"));
        flights.add(new Flight("Warsaw", "Paris"));
        flights.add(new Flight("Krakow", "London"));
        flights.add(new Flight("Gdansk", "Berlin"));
        flights.add(new Flight("Berlin", "Warsaw"));
        flights.add(new Flight("Paris", "Rome"));
    }

    public static List<Flight> getFlightsTable() {
        return flights;
    }
}
