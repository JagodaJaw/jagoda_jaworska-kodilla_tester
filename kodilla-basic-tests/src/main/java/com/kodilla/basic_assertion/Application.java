package com.kodilla.basic_assertion;

public class Application {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        // TEST SUM
        int sumResult = calculator.sum(5, 8);
        boolean sumCorrect = ResultChecker.assertEquals(13, sumResult);

        if (sumCorrect) {
            System.out.println("Metoda sum działa poprawnie");
        } else {
            System.out.println("Metoda sum nie działa poprawnie");
        }

        // TEST SUBTRACT
        int subtractResult = calculator.subtract(10, 4);
        boolean subtractCorrect = ResultChecker.assertEquals(6, subtractResult);

        if (subtractCorrect) {
            System.out.println("Metoda subtract działa poprawnie");
        } else {
            System.out.println("Metoda subtract nie działa poprawnie");
        }

        // TEST SQUARE
        double squareResult = calculator.square(5);
        boolean squareCorrect = ResultChecker.assertEquals(25.0, squareResult);

        if (squareCorrect) {
            System.out.println("Metoda square działa poprawnie");
        } else {
            System.out.println("Metoda square nie działa poprawnie");
        }
    }
}