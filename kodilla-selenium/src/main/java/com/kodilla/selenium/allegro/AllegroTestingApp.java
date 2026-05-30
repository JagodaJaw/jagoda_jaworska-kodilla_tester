package com.kodilla.selenium.allegro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AllegroTestingApp {
    public static void main(String[] args) {
        WebDriver driver = createDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        try {
            driver.get("https://allegro.pl/");
            closeAlertIfPresent(driver);
            acceptCookiesIfPresent(driver);

            if (driver.getCurrentUrl().contains("captcha-delivery.com")) {
                throw new IllegalStateException("Allegro displayed an anti-bot verification page.");
            }

            WebElement categoryCombo = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("select[aria-label*='Kategoria']")));
            Select categorySelect = new Select(categoryCombo);
            categorySelect.selectByVisibleText("Elektronika");

            WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("input[name='string'][type='search']")));
            searchField.sendKeys("Mavic mini");

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button[type='submit'][aria-label='szukaj']")));
            searchButton.click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section article")));
            List<WebElement> products = driver.findElements(By.cssSelector("section article"));

            System.out.println("Found products: " + products.size());
            for (WebElement product : products) {
                System.out.println(product.getText());
                System.out.println("--------------------");
            }
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

    private static void closeAlertIfPresent(WebDriver driver) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException ignored) {
            // Allegro usually shows a cookie dialog instead of a browser alert.
        }
    }

    private static void acceptCookiesIfPresent(WebDriver driver) {
        try {
            List<WebElement> buttons = driver.findElements(By.tagName("button"));
            for (WebElement button : buttons) {
                if (button.getText().contains("Zgadzam się")) {
                    button.click();
                    return;
                }
            }
        } catch (Exception ignored) {
            // The dialog is only shown for a fresh browser profile.
        }
    }
}
