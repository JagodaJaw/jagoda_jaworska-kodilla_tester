package com.kodilla.spring.basic.spring_scopes.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ClockTestSuite {

    @Test
    public void shouldCreateClocksWithDifferentTimes() throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Clock firstClock = context.getBean(Clock.class);
        Thread.sleep(5);
        Clock secondClock = context.getBean(Clock.class);
        Thread.sleep(5);
        Clock thirdClock = context.getBean(Clock.class);

        Assertions.assertNotEquals(firstClock.getTime(), secondClock.getTime());
        Assertions.assertNotEquals(secondClock.getTime(), thirdClock.getTime());
        Assertions.assertNotEquals(firstClock.getTime(), thirdClock.getTime());
    }
}
