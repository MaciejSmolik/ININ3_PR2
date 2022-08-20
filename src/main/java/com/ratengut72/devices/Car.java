package com.ratengut72.devices;

public class Car {

    private final String producer;
    private final String model;
    private Double weight;
    public Double price = 0d;

    public Car(String producer, String model, Double weight) {
        this.producer = producer;
        this.model = model;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;

        if (!producer.equals(car.producer)) return false;
        if (!model.equals(car.model)) return false;
        if (!weight.equals(car.weight)) return false;
        return price.equals(car.price);
    }

    @Override
    public int hashCode() {
        int result = producer.hashCode();
        result = 31 * result + model.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
