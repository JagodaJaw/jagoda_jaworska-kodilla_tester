package com.kodilla.collections.adv.maps.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SchoolDirectory {

    public static void main(String[] args) {

        Map<Principal, School> schoolDirectory = new HashMap<>();

        School school1 = new School("Harvard", Arrays.asList(20, 25, 30));
        School school2 = new School("College", Arrays.asList(15, 10, 20));
        School school3 = new School("Primary school", Arrays.asList(10, 12, 8));

        Principal julia = new Principal("Julia", "Smith");
        Principal tom = new Principal("Tom", "Brown");
        Principal brat = new Principal("Brat", "Green");

        schoolDirectory.put(julia, school1);
        schoolDirectory.put(tom, school2);
        schoolDirectory.put(brat, school3);

        for (Map.Entry<Principal, School> entry : schoolDirectory.entrySet()) {
            System.out.println(
                    entry.getKey().getFirstName() + " " +
                            entry.getKey().getLastName() + " - " +
                            entry.getValue().getName() + " - students: " +
                            entry.getValue().getTotalStudents()
            );
        }
    }
}
