package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightFinderTest {

    @Test
    void testFindFlightsFrom() {
        // given
        FlightFinder finder = new FlightFinder(FlightRepository.getFlightsTable());

        // when
        List<Flight> result = finder.findFlightsFrom("Warsaw");

        // then
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(f -> f.getDeparture().equals("Warsaw")));
    }

    @Test
    void testFindFlightsTo() {
        // given
        FlightFinder finder = new FlightFinder(FlightRepository.getFlightsTable());

        // when
        List<Flight> result = finder.findFlightsTo("London");

        // then
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(f -> f.getArrival().equals("London")));
    }
    @Test
    void testCityNotFound() {
        FlightFinder finder = new FlightFinder(FlightRepository.getFlightsTable());

        List<Flight> result = finder.findFlightsFrom("Madrid");

        assertTrue(result.isEmpty());
    }
    @Test
    void testNullInput() {
        FlightFinder finder = new FlightFinder(FlightRepository.getFlightsTable());

        List<Flight> result = finder.findFlightsFrom(null);

        assertTrue(result.isEmpty());
    }
    @Test
    void testCityOnlyAsArrival() {
        FlightFinder finder = new FlightFinder(FlightRepository.getFlightsTable());

        List<Flight> result = finder.findFlightsFrom("Rome");

        assertTrue(result.isEmpty());
    }
}