package com.kodilla.parametrized_tests.homework;

import java.util.regex.Pattern;

public class UserValidator {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("[A-Za-z0-9._-]{3,}");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");

    public boolean validateUsername(String username) {
        return username != null && USERNAME_PATTERN.matcher(username).matches();
    }

    public boolean validateEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
}
