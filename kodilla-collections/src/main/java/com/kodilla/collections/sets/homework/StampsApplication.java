package com.kodilla.collections.sets.homework;

import java.util.HashSet;
import java.util.Set;

public class StampsApplication {
    public static void main(String[] args) {
        Set<Stamp> stamps = new HashSet<>();
        stamps.add(new Stamp("Star", "2/2", true));
        stamps.add(new Stamp("Ball", "10/10", true));
        stamps.add(new Stamp("Sun", "4/4", false));
        stamps.add(new Stamp("Star", "2/2", true));

        System.out.println(stamps.size());
        for (Stamp stamp : stamps)
            System.out.println(stamp);
    }
}