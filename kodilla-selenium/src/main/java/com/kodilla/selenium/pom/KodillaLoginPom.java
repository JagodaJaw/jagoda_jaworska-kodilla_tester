package com.kodilla.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KodillaLoginPom extends AbstractPom {
    private static final String LOGIN_URL = "https://kodilla.com/pl/test/login";
    private static final String SUCCESS_MESSAGE = "Jesteś teraz zalogowany!";

    @FindBy(css = "input[type='email']")
    WebElement emailField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Log in')]")
    WebElement loginButton;

    private final WebDriverWait wait;

    public KodillaLoginPom(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.navigate().to(LOGIN_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
    }

    public boolean login(String email, String password) {
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();

        String message = wait.until(ExpectedConditions.alertIsPresent()).getText();
        driver.switchTo().alert().dismiss();
        return SUCCESS_MESSAGE.equals(message);
    }
}
