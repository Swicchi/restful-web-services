package com.example.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Bob Car");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Bob","Car"));
    }

    @GetMapping(value = "person/param", params = "version=1")
    public PersonV2 personV1P(){
        return new PersonV2(new Name("Bob","Car"));
    }

    @GetMapping(value = "person/param", params = "version=2" )
    public PersonV2 personV2P(){
        return new PersonV2(new Name("Bob","Car"));
    }

    @GetMapping(value = "person/header", headers = "X-API-VERSION=1")
    public PersonV2 personV1H(){
        return new PersonV2(new Name("Bob","Car"));
    }

    @GetMapping(value = "person/header", headers = "X-API-VERSION=2" )
    public PersonV2 personV2H(){
        return new PersonV2(new Name("Bob","Car"));
    }

    @GetMapping(value = "person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV2 personV1Pr(){
        return new PersonV2(new Name("Bob","Car"));
    }

    @GetMapping(value = "person/produces", produces = "application/vnd.company.app-v2+json" )
    public PersonV2 personV2Pr(){
        return new PersonV2(new Name("Bob","Car"));
    }
}
