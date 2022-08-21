package com.ratengut72.creatures;

public class Pet extends Animal {

    public Pet(String species, String name) {
        super(species, name);
    }

    public Pet(String species, Double weight, String name) {
        super(species, weight, name);
    }
}
