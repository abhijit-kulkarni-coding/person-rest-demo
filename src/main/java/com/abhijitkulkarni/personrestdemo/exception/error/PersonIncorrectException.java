package com.abhijitkulkarni.personrestdemo.exception.error;

public class PersonIncorrectException extends Exception {
    private String message = "";

    public PersonIncorrectException() {
        this.message = "PersonIncorrectException: Details unknown.";
    }

    public PersonIncorrectException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
