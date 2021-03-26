package com.poc.crud.repository;

import com.poc.crud.model.PersonModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PeopleData {

    @Select("SELECT * FROM people")
    List<PersonModel> getAllPeople();

    @Select("SELECT * FROM people WHERE id = #{id}")
    PersonModel getPerson(@Param("id") Integer id);

    @Delete("DELETE FROM people WHERE id=#{id}")
    Integer deletePerson(@Param("id") Integer id);

    @Insert("INSERT INTO people (name, age) VALUES (#{person.name}, #{person.age})")
    void insertPerson(@Param("person") PersonModel person);

    @Update("UPDATE people " +
            "SET " +
            "name = #{person.name}," +
            "age = #{person.age} " +
            "WHERE id = #{id}")
    Integer updatePerson(
            @Param("person") PersonModel person,
            @Param("id") Integer id
    );

}
