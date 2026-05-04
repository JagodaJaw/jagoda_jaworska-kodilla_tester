package com.kodilla.parametrized_tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StringValidatorTest {

    private StringValidator validator = new StringValidator();

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  "})
    public void shouldReturnTrueIfStringIsBlank(String text) {
        assertTrue(validator.isBlank(text));
    }
}
