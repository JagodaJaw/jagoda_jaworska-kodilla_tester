package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShippingCenterTestSuite {

    @Autowired
    private ShippingCenter shippingCenter;

    @Test
    public void shouldReturnSuccessMessageWhenPackageCanBeDelivered() {
        String message = shippingCenter.sendPackage("Hill Street 11, New York", 18.2);
        Assertions.assertEquals("Package delivered to: Hill Street 11, New York", message);
    }

    @Test
    public void shouldReturnFailMessageWhenPackageIsTooHeavy() {
        String message = shippingCenter.sendPackage("Hill Street 11, New York", 31.0);
        Assertions.assertEquals("Package not delivered to: Hill Street 11, New York", message);
    }
}
