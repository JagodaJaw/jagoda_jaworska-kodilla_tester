package com.kodilla.collections.adv.maps.homework;

import java.util.List;

public class School {

    private String name;
    private List<Integer> students;

    public School(String name, List<Integer> students) {
        this.name = name;
        this.students = students;
    }

    public int getTotalStudents() {
        int sum = 0;
        for (int s : students) {
            sum += s;
        }
        return sum;
    }

    public String getName() {
        return name;
    }
}
