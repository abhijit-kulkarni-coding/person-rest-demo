package com.abhijitkulkarni.personrestdemo.exception;

import com.abhijitkulkarni.personrestdemo.exception.error.PersonIncorrectException;
import com.abhijitkulkarni.personrestdemo.exception.error.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonErrorHandler {

    @ExceptionHandler(PersonIncorrectException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public PersonIncorrectException handlePersonIncorrectException(PersonIncorrectException ce) {
        return ce;
    }

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public PersonNotFoundException handlePersonNotFoundException(PersonNotFoundException ce) {
        return ce;
    }
}