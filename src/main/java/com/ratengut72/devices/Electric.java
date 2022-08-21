package com.ratengut72.devices;

public class Electric extends Car {

    public Electric(String producer, String model, Double weight, int yearOfProduction) {
        super(producer, model, weight, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Battery charged to 100%");
    }
}
