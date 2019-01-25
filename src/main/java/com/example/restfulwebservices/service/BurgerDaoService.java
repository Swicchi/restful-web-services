package com.example.restfulwebservices.service;

import com.example.restfulwebservices.model.Burger;
import com.example.restfulwebservices.model.Ingredient;
import com.example.restfulwebservices.model.IngredientPrice;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class BurgerDaoService {
    private static List<Burger> burgers = new ArrayList<>();
    private static int burgerCount = 2;

    static {
        Ingredient ingredient1 = new Ingredient(1, 2, 4, 1);
        burgers.add(new Burger(1, ingredient1, 4 + ingredient1.getSalad() * IngredientPrice.getSalad()
                + ingredient1.getBacon() * IngredientPrice.getBacon()
                + ingredient1.getCheese() * IngredientPrice.getCheese()
                + ingredient1.getMeat() * IngredientPrice.getMeat()));
        Ingredient ingredient2 = new Ingredient(0, 2, 3, 2);
        burgers.add(new Burger(2, ingredient2, 4 + ingredient2.getSalad() * IngredientPrice.getSalad()
                + ingredient2.getBacon() * IngredientPrice.getBacon()
                + ingredient2.getCheese() * IngredientPrice.getCheese()
                + ingredient2.getMeat() * IngredientPrice.getMeat()));
    }

    public List<Burger> findAll() {
        return burgers;
    }

    public Burger save(Burger burger) {
        if (burger.getId() == null || burger.getId() == 0) {
            burger.setId(++burgerCount);
        }
        burgers.add(burger);
        return burger;
    }

    public Burger findOne(int id) {
        for (Burger burger : burgers) {
            if (burger.getId() == id) {
                return burger;
            }
        }
        return null;
    }

    public Burger deleteById(int id) {
        Iterator<Burger> iterator = burgers.iterator();
        while (iterator.hasNext()) {
            Burger burger = iterator.next();
            if (burger.getId() == id) {
                iterator.remove();
                return burger;
            }
        }
        return null;
    }
}
