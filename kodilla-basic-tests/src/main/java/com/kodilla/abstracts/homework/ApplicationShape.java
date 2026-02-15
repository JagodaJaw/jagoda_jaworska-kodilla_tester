package com.kodilla.abstracts.homework;

public class ApplicationShape {

        public static void main(String[] args) {

            Shape square = new Square(4);
            Shape triangle = new Triangle(3);
            Shape wheel = new Wheel(5);

            System.out.println("Square area: " + square.getArea());
            System.out.println("Triangle area: " + triangle.getArea());
            System.out.println("Wheel area: " + wheel.getArea());
        }
    }

