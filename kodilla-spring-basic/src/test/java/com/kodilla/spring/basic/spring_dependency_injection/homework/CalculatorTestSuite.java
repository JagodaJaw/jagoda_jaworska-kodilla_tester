package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void shouldAddNumbers() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        Calculator calculator = context.getBean(Calculator.class);
        double result = calculator.add(2.5, 3.5);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    public void shouldSubtractNumbers() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        Calculator calculator = context.getBean(Calculator.class);
        double result = calculator.subtract(10.0, 4.0);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    public void shouldMultiplyNumbers() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        Calculator calculator = context.getBean(Calculator.class);
        double result = calculator.multiply(2.0, 3.0);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    public void shouldDivideNumbers() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        Calculator calculator = context.getBean(Calculator.class);
        double result = calculator.divide(12.0, 2.0);
        Assertions.assertEquals(6.0, result);
    }
}
