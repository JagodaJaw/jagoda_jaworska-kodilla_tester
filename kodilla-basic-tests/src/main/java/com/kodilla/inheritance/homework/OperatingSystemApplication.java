package com.kodilla.inheritance.homework;

public class OperatingSystemApplication {

        public static void main(String[] args) {

            OperatingSystem windows = new Windows(2020);
            OperatingSystem macOS = new MacOS(2018);

            windows.turnOn();
            windows.turnOff();

            macOS.turnOn();
            macOS.turnOff();
        }
    }
