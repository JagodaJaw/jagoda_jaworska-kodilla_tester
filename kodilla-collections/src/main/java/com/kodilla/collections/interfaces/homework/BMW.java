package com.kodilla.collections.interfaces.homework;

public class BMW implements Car {

    private int speed = 0;

    @Override
    public int getSpeed() {

        return speed;
    }

    @Override
    public void increaseSpeed() {

        speed += 25;
    }

    @Override
    public void decreaseSpeed() {

        speed = Math.max(0, speed - 15);
    }
}