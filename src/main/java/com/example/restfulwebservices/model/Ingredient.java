package com.example.restfulwebservices.model;

public class Ingredient {
    private int salad;
    private int cheese;
    private int bacon;
    private int meat;

    public Ingredient(int salad, int cheese, int bacon, int meat) {
        this.salad = salad;
        this.cheese = cheese;
        this.bacon = bacon;
        this.meat = meat;
    }

    public int getSalad() {
        return salad;
    }

    public void setSalad(int salad) {
        this.salad = salad;
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(int cheese) {
        this.cheese = cheese;
    }

    public int getBacon() {
        return bacon;
    }

    public void setBacon(int bacon) {
        this.bacon = bacon;
    }

    public int getMeat() {
        return meat;
    }

    public void setMeat(int meat) {
        this.meat = meat;
    }
}
