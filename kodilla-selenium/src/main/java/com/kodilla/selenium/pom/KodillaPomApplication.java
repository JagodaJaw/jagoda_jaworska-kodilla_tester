package com.kodilla.selenium.pom;

import org.openqa.selenium.WebDriver;

public class KodillaPomApplication {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.createDriver();

        try {
            KodillaLoginPom loginPom = new KodillaLoginPom(driver);
            loginPom.open();
            loginPom.login("test@kodilla.com", "kodilla123");
        } finally {
            driver.quit();
        }
    }
}
