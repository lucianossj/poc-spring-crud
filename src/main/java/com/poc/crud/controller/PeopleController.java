package com.poc.crud.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @GetMapping(path = "say-hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHello() {
        return "Hello world!";
    }

}
