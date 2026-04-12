package com.kodilla.optional.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        Teacher teacher1 = new Teacher("Tomasz Nowak");
        Teacher teacher2 = new Teacher("Anna Kowalska");

        students.add(new Student("Jan Kowalski", teacher1));
        students.add(new Student("Adam Nowak", teacher2));
        students.add(new Student("Ewa Wiśniewska", null));
        students.add(new Student("Ola Zielińska", null));

        for (Student student : students) {
            System.out.println("uczeń: " + student.getName() +
                    ", nauczyciel: " + getTeacherName(student));
        }
    }

    public static String getTeacherName(Student student) {
        return Optional.ofNullable(student)
                .map(Student::getTeacher)
                .map(Teacher::getName)
                .orElse("<undefined>");
    }
}
