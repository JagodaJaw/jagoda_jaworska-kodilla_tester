package com.kodilla.abstracts.homework;

public class ApplicationShape {

        public static void main(String[] args) {

            Shape square = new Square(4);
            Shape triangle = new EquilateralTriangle(3);
            Shape wheel = new Wheel(5);

            System.out.println("Square area: " + square.getArea());
            System.out.println("Triangle area: " + triangle.getArea());
            System.out.println("Wheel area: " + wheel.getArea());

            System.out.println("Square perimeter: " + square.getPerimeter());
            System.out.println("Triangle perimeter: " + triangle.getPerimeter());
            System.out.println("Wheel perimeter: " + wheel.getPerimeter());
        }
    }