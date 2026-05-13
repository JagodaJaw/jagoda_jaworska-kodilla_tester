package com.kodilla.spring.basic.spring_dependency_injection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleApplicationTestSuite {

    @Autowired
    private SkypeMessageService skypeMessageService;

    @Autowired
    private SimpleApplication simpleApplication;

    @Test
    public void shouldReturnCorrectMessage() {
        String message = skypeMessageService.send("Test", "Any receiver");
        Assertions.assertNotNull(message);
    }

    @Test
    public void shouldProcessMessage() {
        String message = simpleApplication.processMessage("Test", "Any receiver");
        Assertions.assertEquals("Sending [Test] to: Any receiver using Skype", message);
    }
}
