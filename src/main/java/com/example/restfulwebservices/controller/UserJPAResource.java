package com.example.restfulwebservices.controller;

import com.example.restfulwebservices.exceptions.UserNotFoundException;
import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.repository.UserRepository;
import com.example.restfulwebservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa/users")
public class UserJPAResource {

    private final UserRepository service;

    @Autowired
    public UserJPAResource(UserRepository service) {
        this.service = service;
    }

    @GetMapping
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public Resource<User> retrieveUser(@PathVariable int id){
        Optional<User> userOptional = service.findById(id);
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("id-"+id);
        }
        User user = userOptional.get();
        Resource<User> resource = new Resource<>(user);

        ControllerLinkBuilder linkTo=
        linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));
        //HATEOAS
        return resource;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }
}
