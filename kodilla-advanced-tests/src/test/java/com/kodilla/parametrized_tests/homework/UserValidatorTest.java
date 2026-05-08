package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserValidatorTest {

    private UserValidator validator = new UserValidator();

    @ParameterizedTest
    @ValueSource(strings = {"abc", "user123", "john.doe", "anna_nowak", "test-user"})
    public void shouldReturnTrueIfUsernameIsValid(String username) {
        assertTrue(validator.validateUsername(username));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"ab", "user name", "user@name", "jan!"})
    public void shouldReturnFalseIfUsernameIsInvalid(String username) {
        assertFalse(validator.validateUsername(username));
    }

    @ParameterizedTest
    @ValueSource(strings = {"user@example.com", "john.doe@test.pl", "anna_nowak-1@mail.co", "user@sub.example.com"})
    public void shouldReturnTrueIfEmailIsValid(String email) {
        assertTrue(validator.validateEmail(email));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"user", "user@", "@example.com", "user@example", "user example@test.com"})
    public void shouldReturnFalseIfEmailIsInvalid(String email) {
        assertFalse(validator.validateEmail(email));
    }
}
