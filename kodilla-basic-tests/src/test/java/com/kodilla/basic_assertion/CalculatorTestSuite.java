package com.kodilla.basic_assertion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void shouldSubtractPositiveNumbers() {
        double result = calculator.subtract(10, 4);
        assertEquals(6, result, 0.001);
    }

    @Test
    public void shouldSubtractNegativeNumbers() {
        double result = calculator.subtract(-10, -4);
        assertEquals(-6, result, 0.001);
    }

    @Test
    public void shouldSubtractNumbersResultZero() {
        double result = calculator.subtract(5, 5);
        assertEquals(0, result, 0.001);
    }

    @Test
    public void shouldSubtractPositiveAndNegative() {
        double result = calculator.subtract(10, -5);
        assertEquals(15, result, 0.001);
    }

    @Test
    public void shouldSquarePositiveNumber() {
        double result = calculator.square(5);
        assertEquals(25, result, 0.001);
    }

    @Test
    public void shouldSquareZero() {
        double result = calculator.square(0);
        assertEquals(0, result, 0.001);
    }

    @Test
    public void shouldSquareNegativeNumber() {
        double result = calculator.square(-4);
        assertEquals(16, result, 0.001);
    }
}