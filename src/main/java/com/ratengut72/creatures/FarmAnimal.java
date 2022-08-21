package com.ratengut72.creatures;

public class FarmAnimal extends Animal implements Edible {

    public FarmAnimal(String species, String name) {
        super(species, name);
    }

    public FarmAnimal(String species, Double weight, String name) {
        super(species, weight, name);
    }

    @Override
    public void beEaten() {
        isAlive = false;
        weight = 0d;
    }
}
