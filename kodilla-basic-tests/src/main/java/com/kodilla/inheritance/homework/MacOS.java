package com.kodilla.inheritance.homework;

public class MacOS extends OperatingSystem {

    public MacOS(int releaseYear) {
        super(releaseYear);
        System.out.println("MacOS constructor");
    }

    @Override
    public void turnOn() {
        System.out.println("MacOS is booting");
    }

    @Override
    public void turnOff() {
        System.out.println("MacOS is powering off");
    }
}
