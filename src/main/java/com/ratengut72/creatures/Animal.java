package com.ratengut72.creatures;

import java.util.Objects;
import java.util.UUID;

public class Animal implements Sellable {

    final String species;
    private Double weight;
    private String name;
    private Double price;

    public Animal(String species) {
        this.species = species;
        this.weight = WeightEstablisherFactory.establishWeight(species);
        this.name = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void feed() {
        if (weight == 0.0d) {
            System.out.println("You cannot feed dead animal");
        } else {
            Double actual = this.weight;
            weight++;
            System.out.println(String.format("Increasing weight of this animal from: %f to %f", actual, weight));
        }
    }

    public void takeForAWalk() {
        if (weight == 0.0d)
            System.out.println("You cannot take for a walk dead animal");
        else {
            Double actual = this.weight;
            if (weight - 1 < 0d)
                weight = 0d;
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
                '}';
    }
}
