package com.kodilla.selenium.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FormTestApp {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = createDriver();

        try {
            driver.get("https://kodilla.com/pl/test/form");

            WebElement yearCombo = driver.findElement(By.xpath("//*[@id=\"birthday_wrapper\"]/select[3]"));
            Select yearSelect = new Select(yearCombo);
            yearSelect.selectByIndex(5);

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
