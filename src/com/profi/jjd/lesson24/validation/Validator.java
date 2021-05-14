package com.profi.jjd.lesson24.validation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

public class Validator<T> {
    private T forValidation;
    private HashSet<ValidationError> errors;

    public Validator(T forValidation) {
        this.forValidation = forValidation;
        errors = new HashSet<>();
    }
    public HashSet<ValidationError> getErrors(){
        return errors;
    }

    private String firstToUpper(String s){
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
    public void validate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {  // x getX(){}
        Class<?> cl = forValidation.getClass();
        Field[] fields = cl.getDeclaredFields();
        for (Field field: fields){
            if (field.isAnnotationPresent(Min.class)) {
                Min min = field.getDeclaredAnnotation(Min.class);
                Method method = cl.getDeclaredMethod("get" + firstToUpper(field.getName()));
                if ((int) method.invoke(forValidation) < min.value()) {
                    ValidationError error = new ValidationError();
                    error.setFieldName(field.getName());
                    error.setErrorMessage(min.errorMessage() + min.value());
                    errors.add(error);
                }
            }
        }

        /*Min min = field.getDeclaredAnnotation(Min.class);
        min.value();*/

    }
}
