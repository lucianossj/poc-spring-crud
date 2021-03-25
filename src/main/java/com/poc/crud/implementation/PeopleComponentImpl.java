package com.poc.crud.implementation;

import com.poc.crud.model.PersonModel;
import com.poc.crud.repository.PeopleData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeopleComponentImpl implements PeopleComponent {

    private final PeopleData peopleData;

    public PeopleComponentImpl(PeopleData peopleData) {
        this.peopleData = peopleData;
    }

    public List<PersonModel> getAllPeople() {
        return peopleData.getAllPeople();
    }

    public PersonModel getPerson(@Param("id") Integer id) {
        return peopleData.getPerson(id);
    }

    public void deletePerson(Integer id) {
        peopleData.deletePerson(id);
    }

    public void insertPerson(PersonModel person) {
        peopleData.insertPerson(person);
    }

    public Integer updatePerson(PersonModel person, Integer id) {
        return peopleData.updatePerson(person, id);
    }

}
