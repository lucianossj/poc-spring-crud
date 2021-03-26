package com.poc.crud.exception;

public enum SuccessMessageEnum {
    SUCCESSFUL_EDIT("Editado com sucesso."),
    SUCCESSFUL_DELETE("Removido com sucesso.");

    private String successMessage;

    SuccessMessageEnum(String successMessage) {
        this.successMessage =  successMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

}