package com.ratengut72.creatures;

import com.ratengut72.devices.Car;
import com.ratengut72.devices.Diesel;
import com.ratengut72.devices.Phone;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Human {

    private String firstName;
    private String lastName;
    private Double salary = 0d;
    private Double cash = 0d;
    public Animal animal;
    private Car[] garage;
    private Phone phone;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        garage = new Car[3];
    }

    public Human(String firstName, String lastName, int garageCapacity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.garage = new Car[garageCapacity];
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

    public Car[] getGarage() {
        return this.garage;
    }

    public boolean isGarageFull() {
        return Arrays.stream(garage).allMatch(Objects::nonNull);
    }

    public int getFirstEmptyPlaceInGarage() {
        if (!isGarageFull()) {
            for (int i = 0; i < garage.length; i++) {
                if (garage[i] == null)
                    return i;
            }
        }
        return -1;
    }

    public Car getCar(int place) {
        return garage[place];
    }

    public int getIndexOfCar(Car car) {
        for (int i = 0; i < garage.length; i++) {
            if (garage[i].equals(car))
                return i;
        }
        return -1;
    }

    public void setCar(Car car, int place) {
        if (Objects.nonNull(car)) {
            if (garage[place] == null) {
                if (this.salary >= car.getPrice()) {
                    System.out.println("Car bought by cash");
                    this.garage[place] = car;
                    car.getOwners().add(this);
                } else if (this.salary > car.getPrice() / 12.0) {
                    System.out.println("Car bought by loan");
                    this.garage[place] = car;
                    car.getOwners().add(this);
                } else {
                    System.out.println("Better go study or ask your boss for a raise");
                }
            }
        } else if (garage[place] != null) {
            System.out.println("This place is not empty, aborting");
        }
        else
            this.garage[place] = null;
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

    public Double calculateGarageValue() {
        return Arrays.stream(garage).filter(Objects::nonNull).map(car -> car.getPrice()).reduce(0.0,Double::sum);
    }

    public void sortCarsFromOldestToNewest() {
        sortNullsToTheEnd();
        for (int i = 0; i < garage.length - 1; i++) {
            for (int j = 0; j < garage.length - 1 - i; j++) {
                if (Objects.nonNull(garage[j]) && Objects.nonNull(garage[j+1])) {
                    if (garage[j].getYearOfProduction() > garage[j+1].getYearOfProduction()) {
                        swap(garage,j,j+1);
                    }
                }
            }
        }
    }

    private void sortNullsToTheEnd() {
        for (int i = 0; i < garage.length - 1; i++) {
            for (int j = 0; j < garage.length - 1 - i; j++) {
                if (garage[j] == null) {
                    swap(garage,j,j+1);
                }
            }
        }
    }

    private static void swap(Car[] array, int i, int j) {
        Car tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    @Override
    public String toString() {
        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", animal=" + animal +
                ", garage=" + Arrays.toString(garage) +
                '}';
    }
}
