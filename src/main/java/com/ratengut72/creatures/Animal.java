package com.ratengut72.creatures;

import java.util.UUID;

public class Animal {

    final String species;
    private Double weight;
    private String name;

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
}
