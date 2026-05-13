package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void shouldAddNumbers() {
        double result = calculator.add(2.5, 3.5);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    public void shouldSubtractNumbers() {
        double result = calculator.subtract(10.0, 4.0);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    public void shouldMultiplyNumbers() {
        double result = calculator.multiply(2.0, 3.0);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    public void shouldDivideNumbers() {
        double result = calculator.divide(12.0, 2.0);
        Assertions.assertEquals(6.0, result);
    }
}
