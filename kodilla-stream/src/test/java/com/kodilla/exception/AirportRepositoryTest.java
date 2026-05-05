package com.kodilla.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AirportRepositoryTest {

    @Test
    void shouldReturnTrueWhenAirportIsInUse() throws AirportNotFoundException {
        // given
        AirportRepository airportRepository = new AirportRepository();

        // when
        boolean result = airportRepository.isAirportInUse("Warsaw");

        // then
        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenAirportIsNotInUse() throws AirportNotFoundException {
        // given
        AirportRepository airportRepository = new AirportRepository();

        // when
        boolean result = airportRepository.isAirportInUse("LasPalmas");

        // then
        assertFalse(result);
    }

    @Test
    void shouldThrowExceptionWhenAirportDoesNotExist() {
        // given
        AirportRepository airportRepository = new AirportRepository();

        // when & then
        AirportNotFoundException exception =
                assertThrows(AirportNotFoundException.class, () -> airportRepository.isAirportInUse("Berlin"));
        assertEquals("Airport not found", exception.getMessage());
    }
}
