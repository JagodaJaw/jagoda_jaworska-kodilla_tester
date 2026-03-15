package com.kodilla.collections.interfaces.homework;

public class Fiat implements Car {


        private int speed = 0;

        @Override
        public int getSpeed() {
            return speed;
        }

        @Override
        public void increaseSpeed() {
            speed += 10;
        }

        @Override
        public void decreaseSpeed() {
            speed -= 5;
        }
    }
