package com.ratengut72.devices;

import com.ratengut72.creatures.Human;
import com.ratengut72.creatures.Sellable;

public class Car extends Device implements Sellable {

    private Double weight;
    public Double price = 0d;

    public Car(String producer, String model, Double weight, int yearOfProduction) {
        super(producer,model,yearOfProduction);
        this.weight = weight;
    }

    @Override
    public void turnOn() {
        System.out.println("Car turned on");
    }

    @Override
    public boolean sell(Human seller, Human buyer, Double price) {
        if (seller.getCar()== null || !seller.getCar().equals(this))  {
            System.out.println("Seller doesn't have that car for sell. It's scam.");
            return false;
        }
        if (buyer.getCash() < price) {
            System.out.println("Buyer doesn't have enough money. Aborting.");
            return false;
        }

        buyer.setCar(this);
        seller.setCar(null);
        seller.addMoney(price);
        buyer.decreaseMoney(price);
        System.out.println("Transaction between " + seller + " and " + buyer + " is done successfully.");
        return true;
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
