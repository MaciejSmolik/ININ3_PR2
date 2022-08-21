package com.ratengut72.devices;

public class Diesel extends Car {

    public Diesel(String producer, String model, Double weight, int yearOfProduction) {
        super(producer, model, weight, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Fuelled with diesel to 100%");
    }
}
