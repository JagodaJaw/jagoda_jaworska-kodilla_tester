package com.kodilla.parametrized_tests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class StringSources {

    static Stream<Arguments> provideStringsForTestingLength() {
        return Stream.of(
                Arguments.of("test", 4),
                Arguments.of("OtHEr ", 5),
                Arguments.of("E V e n t", 5),
                Arguments.of("null ", 4),
                Arguments.of("A", 1)
        );
    }

    public static Stream<Arguments> providePeopleForTestingBMI() {
        return Stream.of(
                Arguments.of(1.0, 14.9, "Very severely underweight"),
                Arguments.of(1.0, 15.5, "Severely underweight"),
                Arguments.of(1.0, 18.0, "Underweight"),
                Arguments.of(1.0, 22.0, "Normal (healthy weight)"),
                Arguments.of(1.0, 27.0, "Overweight"),
                Arguments.of(1.0, 32.0, "Obese Class I (Moderately obese)"),
                Arguments.of(1.0, 37.0, "Obese Class II (Severely obese)"),
                Arguments.of(1.0, 42.0, "Obese Class III (Very severely obese)"),
                Arguments.of(1.0, 47.0, "Obese Class IV (Morbidly Obese)"),
                Arguments.of(1.0, 55.0, "Obese Class V (Super Obese)"),
                Arguments.of(1.0, 65.0, "Obese Class VI (Hyper Obese)")
        );
    }
}
