package com.poc.crud.implementation;

import com.poc.crud.model.PersonModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PeopleComponent {

    ResponseEntity<List<PersonModel>> getAllPeople();

    ResponseEntity<PersonModel> getPerson(@Param("id") Integer id);

    ResponseEntity deletePerson(@Param("id") Integer id);

    void insertPerson(@Param("person") PersonModel person);

    ResponseEntity updatePerson(
            @Param("person") PersonModel person,
            @Param("id") Integer id
    );

}
