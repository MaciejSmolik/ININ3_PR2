package com.ratengut72.devices;

public class LPG extends Car {

    public LPG(String producer, String model, int yearOfProduction, Double weight) {
        super(producer, model, yearOfProduction, weight);
    }

    public LPG(String producer, String model, int yearOfProduction, Double weight, Double price) {
        super(producer, model, yearOfProduction, weight, price);
    }

    @Override
    public void refuel() {
        System.out.println("Fuelled with LPG to 100%");
    }
}
