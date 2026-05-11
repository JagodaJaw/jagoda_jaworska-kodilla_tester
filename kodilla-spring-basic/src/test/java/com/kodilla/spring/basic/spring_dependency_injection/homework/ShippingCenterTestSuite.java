package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ShippingCenterTestSuite {

    @Test
    public void shouldReturnSuccessMessageWhenPackageCanBeDelivered() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        ShippingCenter shippingCenter = context.getBean(ShippingCenter.class);
        String message = shippingCenter.sendPackage("Hill Street 11, New York", 18.2);
        Assertions.assertEquals("Package delivered to: Hill Street 11, New York", message);
    }

    @Test
    public void shouldReturnFailMessageWhenPackageIsTooHeavy() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        ShippingCenter shippingCenter = context.getBean(ShippingCenter.class);
        String message = shippingCenter.sendPackage("Hill Street 11, New York", 31.0);
        Assertions.assertEquals("Package not delivered to: Hill Street 11, New York", message);
    }
}
