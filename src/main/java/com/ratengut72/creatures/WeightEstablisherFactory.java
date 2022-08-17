package com.ratengut72.creatures;

public class WeightEstablisherFactory {

    public static final Double DEFAULT_DOG_WEIGHT = 10d;
    public static final Double DEFAULT_CAT_WEIGHT = 5d;
    public static final Double DEFAULT_MOUSE_WEIGHT = 0.01;

    private WeightEstablisherFactory() {}

    public static Double establishWeight(String species) {
        return switch (species) {
            case "dog" -> DEFAULT_DOG_WEIGHT;
            case "cat" -> DEFAULT_CAT_WEIGHT;
            case "mouse" -> DEFAULT_MOUSE_WEIGHT;
            default -> 0d;
        };
    }
}
