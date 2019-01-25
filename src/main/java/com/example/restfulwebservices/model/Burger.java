package com.example.restfulwebservices.model;

public class Burger {
    private Integer id;
    private Ingredient ingredients;
    private double price;

    public Burger(int id, Ingredient ingredients, double price) {
        this.id = id;
        this.ingredients = ingredients;
        this.price=price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ingredient getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
