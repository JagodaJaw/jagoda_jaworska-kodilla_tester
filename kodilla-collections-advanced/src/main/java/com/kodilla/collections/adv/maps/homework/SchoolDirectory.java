package com.kodilla.collections.adv.maps.homework;


import com.kodilla.collections.adv.maps.complex.Grades;
import com.kodilla.collections.adv.maps.complex.Student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SchoolDirectory {

    public static void main(String[] args) {

        Map<School, Principal> schoolDirectory = new HashMap<>();

        School school1 = new School("Harvard", Arrays.asList(20, 25, 30));
        School school2 = new School("College", Arrays.asList(15, 10, 20));
        School school3 = new School("Primary school", Arrays.asList(10, 12, 8));

        Principal julia = new Principal("Julia", "Harvard");
        Principal tom = new Principal("Tom", "College");
        Principal brat = new Principal("Brat", "Primary school");

        schoolDirectory.put(school1, julia);
        schoolDirectory.put(school2, tom);
        schoolDirectory.put(school3, brat);

        for (Map.Entry<School, Principal> entry : schoolDirectory.entrySet()) {
            System.out.println(
                    entry.getValue().getFirstName() + " - " +
                            entry.getKey().getName() + " - students: " +
                            entry.getKey().getTotalStudents());
        }
    }
}
