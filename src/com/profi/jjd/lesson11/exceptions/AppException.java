package com.profi.jjd.lesson11.exceptions;

public class AppException extends Exception {
    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return " Переопределение метода = " + super.getMessage();
    }
}
