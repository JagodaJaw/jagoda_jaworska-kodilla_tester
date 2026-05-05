package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GamblingMachineTest {

    private GamblingMachine machine = new GamblingMachine();

    @ParameterizedTest
    @CsvFileSource(resources = "/GamblingMachineValidNumbers.csv", delimiter = ';', encoding = "UTF-8", lineSeparator = "\n")
    public void shouldReturnNumberOfWinsForValidNumbers(String numbers) {
        int wins = machine.howManyWins(parseNumbers(numbers));

        assertTrue(wins >= 0 && wins <= 6);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/GamblingMachineInvalidNumbers.csv", delimiter = ';', encoding = "UTF-8", lineSeparator = "\n", nullValues = "NULL")
    public void shouldThrowExceptionForInvalidNumbers(String numbers) {
        assertThrows(InvalidNumbersException.class, () -> machine.howManyWins(parseNumbers(numbers)));
    }

    private Set<Integer> parseNumbers(String numbers) {
        if (numbers == null) {
            return null;
        }
        return Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toSet());
    }
}
