package com.ratengut72.creatures;

import java.time.LocalDate;

public class Human {

    private String firstName;
    private String lastName;
    private Double salary = 0d;
    Animal animal;
    Car car;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        LocalDate Datetime = LocalDate.now();
        System.out.println("Info about salary was given in " + Datetime + ", salary value: " + salary);
        return salary;
    }

    public void setSalary(Double salary) {
        if (salary < 0.0) {
            System.out.println("Salary cannot be less than 0");
        } else {
            System.out.println("New data in system for salary");
            System.out.println("Please take annex from HR");
            System.out.println("ZUS and US know about new salary");
            this.salary = salary;
        }
    }
}
