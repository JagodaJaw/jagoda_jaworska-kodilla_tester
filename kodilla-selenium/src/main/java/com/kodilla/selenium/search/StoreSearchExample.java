package com.kodilla.selenium.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StoreSearchExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium-drivers\\Chrome\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://kodilla.com/pl/test/store");

        WebElement inputField = driver.findElement(By.name("search"));
        inputField.sendKeys("School");
    }
}
