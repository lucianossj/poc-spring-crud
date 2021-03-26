package com.poc.crud.implementation;

import com.poc.crud.exception.ErrorsMessageEnum;
import com.poc.crud.exception.SuccessMessageEnum;
import com.poc.crud.model.PersonModel;
import com.poc.crud.repository.PeopleData;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class PeopleComponentImpl implements PeopleComponent {

    private final PeopleData peopleData;

    public PeopleComponentImpl(PeopleData peopleData) {
        this.peopleData = peopleData;
    }

    public ResponseEntity<List<PersonModel>> getAllPeople() {
        return this.validateFoundPeople();
    }

    public ResponseEntity<PersonModel> getPerson(@Param("id") Integer id) {
        return this.validateFoundPerson(id);
    }

    public ResponseEntity deletePerson(Integer id) {
        Integer updatedRows = peopleData.deletePerson(id);

        if (this.validateHaveNotUpdatedRows(updatedRows)) {
            return this.returnNotFoundResponse(ErrorsMessageEnum.PERSON_NOT_FOUND);
        }
        return this.returnNoContentResponse(SuccessMessageEnum.SUCCESSFUL_DELETE);
    }

    public void insertPerson(PersonModel person) {
        peopleData.insertPerson(person);
    }

    public ResponseEntity updatePerson(PersonModel person, Integer id) {
        Integer updatedRows = peopleData.updatePerson(person, id);

        if (this.validateHaveNotUpdatedRows(updatedRows)) {
            return this.returnNotFoundResponse(ErrorsMessageEnum.PERSON_NOT_FOUND);
        }
        return new ResponseEntity(SuccessMessageEnum.SUCCESSFUL_EDIT.getSuccessMessage(), HttpStatus.NO_CONTENT);
    }

    private ResponseEntity<List<PersonModel>> validateFoundPeople() {
        List<PersonModel> people = peopleData.getAllPeople();

        if (people.isEmpty()) {
            return this.returnNotFoundResponse(ErrorsMessageEnum.PEOPLE_NOT_FOUND);
        }
        return new ResponseEntity(people, HttpStatus.OK);
    }

    private ResponseEntity<PersonModel> validateFoundPerson(Integer id) {
        PersonModel person = peopleData.getPerson(id);

        if (Objects.isNull(person)) {
            return this.returnNotFoundResponse(ErrorsMessageEnum.PERSON_NOT_FOUND);
        }
        return new ResponseEntity(person, HttpStatus.OK);
    }

    private Boolean validateHaveNotUpdatedRows(Integer updatedRows) {
        return Objects.isNull(updatedRows) || updatedRows == 0;
    }

    private ResponseEntity returnNoContentResponse(SuccessMessageEnum successMessage) {
        return new ResponseEntity(successMessage.getSuccessMessage(), HttpStatus.NO_CONTENT);
    }

    private ResponseEntity returnNotFoundResponse(ErrorsMessageEnum error) {
        return new ResponseEntity(error.getErrorMessage(), HttpStatus.NOT_FOUND);
    }

}
