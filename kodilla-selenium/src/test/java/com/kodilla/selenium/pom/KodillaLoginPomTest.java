package com.kodilla.selenium.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KodillaLoginPomTest {
    private WebDriver driver;
    private KodillaLoginPom loginPom;

    @BeforeEach
    public void setup() {
        driver = WebDriverFactory.createDriver();
        loginPom = new KodillaLoginPom(driver);
        loginPom.open();
    }

    @Test
    public void testLoginPage_CheckErrorValidation() {
        boolean loggedIn = loginPom.login("test@toniedziala.pl", "password");
        assertFalse(loggedIn);
    }

    @Test
    public void testLoginPage_CheckPositiveValidation() {
        boolean loggedIn = loginPom.login("test@kodilla.com", "kodilla123");
        assertTrue(loggedIn);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
