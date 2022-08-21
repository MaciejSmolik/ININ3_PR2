package com.ratengut72.devices;

import com.ratengut72.creatures.Sellable;

public abstract class Device implements Sellable {

    protected final String producer;
    protected final String model;
    protected final int yearOfProduction;

    public Device(String producer, String model, int yearOfProduction) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
    }

    protected abstract void turnOn();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device device)) return false;

        if (yearOfProduction != device.yearOfProduction) return false;
        if (!producer.equals(device.producer)) return false;
        return model.equals(device.model);
    }

    @Override
    public int hashCode() {
        int result = producer.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + yearOfProduction;
        return result;
    }

    @Override
    public String toString() {
        return "Device{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}
