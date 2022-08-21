package com.ratengut72.creatures;

import com.ratengut72.devices.Car;
import com.ratengut72.devices.Phone;

import java.time.LocalDate;
import java.util.Objects;

public class Human {

    private String firstName;
    private String lastName;
    private Double salary = 0d;
    private Double cash = 0d;
    public Animal animal;
    private Car car;
    private Phone phone;

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        if (Objects.nonNull(car)) {
            if (this.salary >= car.price) {
                System.out.println("Car bought by cash");
                this.car = car;
            } else if (this.salary > car.price / 12.0) {
                System.out.println("Car bought by loan");
                this.car = car;
            } else {
                System.out.println("Better go study or ask your boss for a raise");
            }
        }
        else
            this.car = null;
    }


    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public void addMoney(Double amount) {
        if (Objects.nonNull(amount))
            cash += amount;
    }

    public void decreaseMoney(Double amount) {
        if (Objects.nonNull(amount))
            cash -= amount;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", animal=" + animal +
                ", car=" + car +
                '}';
    }
}
