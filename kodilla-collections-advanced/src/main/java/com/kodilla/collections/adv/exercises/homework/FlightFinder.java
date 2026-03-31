package com.kodilla.collections.adv.exercises.homework;

import java.util.ArrayList;
import java.util.List;

public class FlightFinder {

    private List<Flight> flights;

    public FlightFinder(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> findFlightsFrom(String departure) {
        List<Flight> result = new ArrayList<>();

        if (departure == null) return result;

        for (Flight flight : flights) {
            if (flight.getDeparture().equals(departure)) {
                result.add(flight);
            }
        }

        return result;
    }

    public List<Flight> findFlightsTo(String arrival) {
        List<Flight> result = new ArrayList<>();

        if (arrival == null) return result;

        for (Flight flight : flights) {
            if (flight.getArrival().equals(arrival)) {
                result.add(flight);
            }
        }

        return result;
    }
}

