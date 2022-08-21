package com.ratengut72.devices;

public class LPG extends Car {

    public LPG(String producer, String model, Double weight, int yearOfProduction) {
        super(producer, model, weight, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Fuelled with LPG to 100%");
    }
}
