package com.kodilla.collections.adv.immutable.homework;

public class Task {

    private final int duration;
    private final String title;

    public Task(int duration, String title) {
        this.duration = duration;
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }
}