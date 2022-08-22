package com.ratengut72.devices;

public class Diesel extends Car {

    public Diesel(String producer, String model, int yearOfProduction, Double weight) {
        super(producer, model, yearOfProduction, weight);
    }

    public Diesel(String producer, String model, int yearOfProduction, Double weight, Double price) {
        super(producer, model, yearOfProduction, weight, price);
    }

    @Override
    public void refuel() {
        System.out.println("Fuelled with diesel to 100%");
    }
}
