package com.kodilla.abstracts.homework;

public class Wheel extends Shape{

        private double radius;

        public Wheel(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
    }

