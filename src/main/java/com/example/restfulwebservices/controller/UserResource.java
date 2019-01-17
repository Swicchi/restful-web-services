package com.example.restfulwebservices.controller;

import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.service.UserDaoService;
import com.example.restfulwebservices.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserDaoService service;

    @Autowired
    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user==null){
            throw new UserNotFoundException("id-"+id);
        }
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);
        if(user==null){
            throw new UserNotFoundException("id-"+id);
        }
    }
}
