package com.kodilla.abstracts.homework;

public class ApplicationJob {

    public static void main(String[] args) {

        Developer developer = new Developer();
        Teacher teacher = new Teacher();
        Doctor doctor = new Doctor();

        Person person1 = new Person("Anna", 30, developer);
        Person person2 = new Person("Tom", 45, teacher);
        Person person3 = new Person("Harry", 35, doctor);

        person1.showResponsibilities();
        person2.showResponsibilities();
        person3.showResponsibilities();
        person1.showSalary();
        person2.showSalary();
        person3.showSalary();
    }
}
