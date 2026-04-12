package com.kodilla.optional.homework;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void testStudentWithTeacher() {
        Teacher teacher = new Teacher("Tomasz Nowak");
        Student student = new Student("Jan Kowalski", teacher);

        String result = Application.getTeacherName(student);

        assertEquals("Tomasz Nowak", result);
    }

    @Test
    void testStudentWithoutTeacher() {
        Student student = new Student("Jan Kowalski", null);

        String result = Application.getTeacherName(student);

        assertEquals("<undefined>", result);
    }

    @Test
    void testTeacherWithEmptyName() {
        Teacher teacher = new Teacher("");
        Student student = new Student("Jan", teacher);

        String result = Application.getTeacherName(student);

        assertEquals("", result);
    }

    @Test
    void testTeacherWithNullName() {
        Teacher teacher = new Teacher(null);
        Student student = new Student("Jan", teacher);

        String result = Application.getTeacherName(student);

        assertEquals("<undefined>", result);
    }

    @Test
    void testStudentWithEmptyName() {
        Teacher teacher = new Teacher("Anna");
        Student student = new Student("", teacher);

        String result = Application.getTeacherName(student);

        assertEquals("Anna", result);
    }

    @Test
    void testNullStudent() {
        String result = Application.getTeacherName(null);

        assertEquals("<undefined>", result);
    }

    @Test
    void testMultipleStudents() {
        Teacher teacher = new Teacher("Anna");

        List<Student> students = List.of(
                new Student("A", teacher),
                new Student("B", null),
                new Student("C", teacher)
        );

        List<String> results = students.stream()
                .map(Application::getTeacherName)
                .toList();

        assertEquals(3, results.size());
        assertEquals("Anna", results.get(0));
        assertEquals("<undefined>", results.get(1));
        assertEquals("Anna", results.get(2));
    }
}