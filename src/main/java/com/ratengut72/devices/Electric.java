package com.ratengut72.devices;

public class Electric extends Car {

    public Electric(String producer, String model, int yearOfProduction, Double weight) {
        super(producer, model, yearOfProduction, weight);
    }

    public Electric(String producer, String model, int yearOfProduction, Double weight, Double price) {
        super(producer, model, yearOfProduction, weight, price);
    }

    @Override
    public void refuel() {
        System.out.println("Battery charged to 100%");
    }
}
