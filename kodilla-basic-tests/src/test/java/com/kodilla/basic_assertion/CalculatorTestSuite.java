package com.kodilla.basic_assertion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();

        double result = calculator.subtract(10, 4);

        assertEquals(6, result, 0.001);
    }

    @Test
    public void testSquarePositiveNumber() {
        Calculator calculator = new Calculator();

        double result = calculator.square(5);

        assertEquals(25, result, 0.001);
    }

    @Test
    public void testSquareZero() {
        Calculator calculator = new Calculator();

        double result = calculator.square(0);

        assertEquals(0, result, 0.001);
    }

    @Test
    public void testSquareNegativeNumber() {
        Calculator calculator = new Calculator();

        double result = calculator.square(-4);

        assertEquals(16, result, 0.001);
    }
}