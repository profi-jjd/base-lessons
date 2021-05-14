package com.profi.jjd.lesson24.validation;

public class ValidationError {
    private String fieldName;
    private String errorMessage;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

// аннотации Min, Max (для чисел): value, errorMessage
// аннотация Future (для дат и времени): errorMessage
