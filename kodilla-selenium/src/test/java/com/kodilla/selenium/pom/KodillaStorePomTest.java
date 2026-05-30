package com.kodilla.selenium.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KodillaStorePomTest {
    private WebDriver driver;
    private KodillaStorePom storePom;

    @BeforeEach
    public void setup() {
        driver = WebDriverFactory.createDriver();
        storePom = new KodillaStorePom(driver);
        storePom.open();
    }

    @Test
    public void shouldReturnExpectedNumberOfProductsForSearchPhrases() {
        Map<String, Integer> expectedResults = createExpectedResults();

        expectedResults.forEach((phrase, expectedCount) ->
                assertEquals(expectedCount, storePom.search(phrase)));
    }

    @Test
    public void shouldIgnoreLetterCaseWhenSearchingProducts() {
        Map<String, Integer> expectedResults = createExpectedResults();

        expectedResults.forEach((phrase, expectedCount) -> {
            assertEquals(expectedCount, storePom.search(phrase.toLowerCase()));
            assertEquals(expectedCount, storePom.search(phrase.toUpperCase()));
        });
    }

    private Map<String, Integer> createExpectedResults() {
        Map<String, Integer> expectedResults = new HashMap<>();
        expectedResults.put("NoteBook", 2);
        expectedResults.put("School", 1);
        expectedResults.put("Brand", 1);
        expectedResults.put("Business", 0);
        expectedResults.put("Gaming", 1);
        expectedResults.put("Powerful", 0);
        return expectedResults;
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
