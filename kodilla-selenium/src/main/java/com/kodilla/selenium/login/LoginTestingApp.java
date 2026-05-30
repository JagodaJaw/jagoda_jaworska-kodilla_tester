package com.kodilla.selenium.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTestingApp {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = createDriver();

        try {
            driver.get("https://kodilla.com/pl/test/login");

            WebElement emailField = driver.findElement(By.xpath("//html/body/section/form/div[1]/input"));
            emailField.sendKeys("test@kodilla.com");

            WebElement passwordField = driver.findElement(By.xpath("//html/body/section/form/div[2]/input"));
            passwordField.sendKeys("kodilla123");

            Thread.sleep(5000);
        } finally {
            driver.quit();
        }
    }

    private static WebDriver createDriver() {
        String browser = System.getProperty("browser", "chrome");

        if ("firefox".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.gecko.driver", "C:\\selenium-drivers\\Firefox\\geckodriver.exe");
            return new FirefoxDriver();
        }

        System.setProperty("webdriver.chrome.driver", "C:\\selenium-drivers\\Chrome\\chromedriver.exe");
        return new ChromeDriver();
    }
}
