package com.kodilla.parametrized_tests;

public class StringManipulator {

    public String reverseWithLowerCase(String input) {
        StringBuilder builder = new StringBuilder(input);
        return builder.reverse().toString().toLowerCase();
    }

    public int countNumberOfCommas(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ',') {
                count++;
            }
        }
        return count;
    }
}
