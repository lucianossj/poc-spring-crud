package com.poc.crud.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonModel {

    public Integer id;

    @NotBlank(message = "Nome é obrigatório")
    @NotNull(message = "Nome não pode ser nulo.")
    public String name;

    @NotNull(message = "Idade não pode ser nula.")
    @Min(value = 18, message = "Idade mínima de 18 anos.")
    public Integer age;

}
