package com.abhijitkulkarni.personrestdemo.exception.error;

public class PersonNotFoundException extends Exception {
    private String message = "";

    public PersonNotFoundException() {
        this.message = "PersonNotFoundException: Details unknown.";
    }

    public PersonNotFoundException(String message) {
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
