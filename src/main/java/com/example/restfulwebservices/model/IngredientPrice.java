package com.example.restfulwebservices.model;

public class IngredientPrice {
    private static final double salad = 0.5;
    private static final double cheese = 0.4;
    private static final double bacon = 0.7;
    private static final double meat = 1.3;

    public static double getSalad() {
        return salad;
    }

    public static double getCheese() {
        return cheese;
    }

    public static double getBacon() {
        return bacon;
    }

    public static double getMeat() {
        return meat;
    }

}
