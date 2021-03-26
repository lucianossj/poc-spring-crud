package com.poc.crud.exception;

public enum ErrorsMessageEnum {
    PEOPLE_NOT_FOUND("Não foram encontradas pessoas."),
    PERSON_NOT_FOUND("Pessoa não encontrada.");

    private String errorMessage;

    ErrorsMessageEnum(String errorMessage) {
        this.errorMessage =  errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}