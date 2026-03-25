package com.kodilla.collections.adv.immutable.homework;

public class Task {

    protected int duration;
    protected String title;

    public void Book(int duration, String title) {
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
