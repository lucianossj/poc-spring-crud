package com.poc.crud.controller;

import com.poc.crud.implementation.PeopleComponentImpl;
import com.poc.crud.model.PersonModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/people")
@Validated
public class PeopleController {

    private final PeopleComponentImpl peopleComponent;

    public PeopleController(PeopleComponentImpl peopleComponent) {
        this.peopleComponent = peopleComponent;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonModel>> getAllPeople() {
        return peopleComponent.getAllPeople();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonModel> getPerson(@PathVariable("id") Integer id) {
        return peopleComponent.getPerson(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deletePerson(@PathVariable("id") Integer id) {
        return peopleComponent.deletePerson(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertPerson(@Valid @RequestBody PersonModel person) {
        peopleComponent.insertPerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePerson(
            @PathVariable("id") Integer id,
            @Valid @RequestBody PersonModel person) {
        return peopleComponent.updatePerson(person, id);
    }
}
