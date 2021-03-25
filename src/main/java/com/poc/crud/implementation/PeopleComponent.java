package com.poc.crud.implementation;

import com.poc.crud.model.PersonModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PeopleComponent {

    List<PersonModel> getAllPeople();

    PersonModel getPerson(@Param("id") Integer id);

    void deletePerson(@Param("id") Integer id);

    void insertPerson(@Param("person") PersonModel person);

    Integer updatePerson(
            @Param("person") PersonModel person,
            @Param("id") Integer id
    );

}
