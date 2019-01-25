package com.example.restfulwebservices.controller;

import com.example.restfulwebservices.model.Burger;
import com.example.restfulwebservices.service.BurgerDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private final BurgerDaoService burgerDaoService;

    @Autowired
    public BurgerController(BurgerDaoService burgerDaoService) {
        this.burgerDaoService = burgerDaoService;
    }

    @GetMapping
    public List<Burger> retrieveBurgers (){
        return burgerDaoService.findAll();
    }

    @PostMapping
    public Burger saveBurger(@RequestBody Burger burger){
        return burgerDaoService.save(burger);
    }
}
