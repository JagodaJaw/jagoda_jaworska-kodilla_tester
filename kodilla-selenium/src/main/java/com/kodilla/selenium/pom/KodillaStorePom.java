package com.kodilla.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;

public class KodillaStorePom extends AbstractPom {
    private static final String STORE_URL = "https://kodilla.com/pl/test/store";

    @FindBy(id = "searchField")
    WebElement searchField;

    private final WebDriverWait wait;

    public KodillaStorePom(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(STORE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchField")));
    }

    public int search(String phrase) {
        searchField.clear();
        searchField.sendKeys(phrase);
        waitForSearchResults(phrase);
        return driver.findElements(By.className("element")).size();
    }

    private void waitForSearchResults(String phrase) {
        wait.until(driver -> {
            List<WebElement> products = driver.findElements(By.className("element"));
            List<WebElement> missingMessages = driver.findElements(By.className("missing"));

            if (!missingMessages.isEmpty()) {
                return true;
            }

            return !products.isEmpty() && products.stream()
                    .allMatch(product -> containsIgnoreCase(product.getText(), phrase));
        });
    }

    private boolean containsIgnoreCase(String text, String phrase) {
        return text.toLowerCase(Locale.ROOT).contains(phrase.toLowerCase(Locale.ROOT));
    }
}
