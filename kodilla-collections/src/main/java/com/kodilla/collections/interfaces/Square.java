package com.kodilla.collections.interfaces;

import java.util.Objects;

public class Square implements Shape {

    private double width;

    public Square(double width) {
        this.width = width;
    }

    public double getArea() {
        return width * width;
    }

    public double getPerimeter() {
        return 4 * width;
    }

    @Override
    public String toString() {
        return "Square{" +
                "width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(width, square.width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(width);
    }
}
