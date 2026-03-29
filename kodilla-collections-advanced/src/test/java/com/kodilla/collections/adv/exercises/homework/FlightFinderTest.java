package com.kodilla.collections.adv.exercises.homework;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightFinderTest {

    @Test
    void testFindFlightsFrom() {
        // given
        FlightFinder finder = new FlightFinder();

        // when
        List<Flight> result = finder.findFlightsFrom("Warsaw");

        // then
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(f -> f.getDeparture().equals("Warsaw")));
    }

    @Test
    void testFindFlightsTo() {
        // given
        FlightFinder finder = new FlightFinder();

        // when
        List<Flight> result = finder.findFlightsTo("London");

        // then
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(f -> f.getArrival().equals("London")));
    }
}