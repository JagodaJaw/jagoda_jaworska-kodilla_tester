package com.kodilla.inheritance.homework;

public class OperatingSystemApplication {

        public static void main(String[] args) {

            OperatingSystem windows = new Windows(2020);
            OperatingSystem MacOS = new MacOS(2018);

            windows.turnOn();
            windows.turnOff();

            MacOS.turnOn();
            MacOS.turnOff();
        }
    }
