package com.kodilla.abstracts.homework;

public class Triangle extends Shape{

        private double side;

        public Triangle(double side) {
            this.side = side;
        }

        @Override
        public double getArea() {
            return (Math.sqrt(3) / 4) * side * side;
        }

        @Override
        public double getPerimeter() {
            return 3 * side;
        }
    }

