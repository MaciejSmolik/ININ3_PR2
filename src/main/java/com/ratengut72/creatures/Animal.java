package com.ratengut72.creatures;

import java.util.Objects;

public abstract class Animal implements Sellable, Feedable {

    protected final String species;
    protected Double weight;
    protected String name;
    protected boolean isAlive = true;
    protected Double price = 0.0;

    public Animal(String species, String name) {
        this.species = species;
        this.name = name;
        this.weight = WeightEstablisherFactory.establishWeight(species);
    }

    public Animal(String species, Double weight, String name) {
        this.species = species;
        this.weight = weight;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void feed() {
        if (!isAlive) {
            System.out.println("You cannot feed dead animal");
        } else {
            Double actual = this.weight;
            weight++;
            System.out.println(String.format("Increasing weight of this animal from: %f to %f", actual, weight));
        }
    }

    @Override
    public void feed(Double weight) {
        if (weight == null || weight <= 0.0)
            System.out.println("You cannot feed with weight less or equal 0.0");
        this.weight += weight;

    }

    public void takeForAWalk() {
        if (!isAlive)
            System.out.println("You cannot take for a walk dead animal");
        else {
            Double actual = this.weight;
            if (weight - 1 < 0d) {
                weight = 0d;
                isAlive = false;
            }
            else
                weight--;
            System.out.println(String.format("Decreasing weight of this animal from: %f to %f", actual, weight));
        }
    }

    @Override
    public boolean sell(Human seller, Human buyer, Double price) {
        if (seller.animal == null || !seller.animal.equals(this))  {
            System.out.println("Seller doesn't have that animal for sell. It's scam.");
            return false;
        }
        if (buyer.getCash() < price) {
            System.out.println("Buyer doesn't have enough money. Aborting.");
            return false;
        }

        buyer.animal = seller.animal;
        seller.animal = null;
        seller.addMoney(price);
        buyer.decreaseMoney(price);
        System.out.println("Transaction between " + seller + " and " + buyer + " is done successfully.");
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;

        if (!Objects.equals(species, animal.species)) return false;
        if (!Objects.equals(weight, animal.weight)) return false;
        if (!Objects.equals(name, animal.name)) return false;
        return Objects.equals(price, animal.price);
    }

    @Override
    public int hashCode() {
        return species != null ? species.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", isAlive=" + isAlive +
                ", price=" + price +
                '}';
    }
}
