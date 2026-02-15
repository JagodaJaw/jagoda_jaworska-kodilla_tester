package com.kodilla.inheritance.homework;

public class OperatingSystem {

    private int Year;

        public OperatingSystem(int Year) {
            this.Year = Year;
            System.out.println("Operating System released in " + Year);
        }

        public void turnOn() {
            System.out.println("Operating system is turning on");
        }

        public void turnOff() {
            System.out.println("Operating system is turning off");
        }

            public int getYear() {
                return Year;
        }
    }
