package com.abhijitkulkarni.personrestdemo.controller;

import com.abhijitkulkarni.personrestdemo.exception.error.PersonIncorrectException;
import com.abhijitkulkarni.personrestdemo.exception.error.PersonNotFoundException;
import com.abhijitkulkarni.personrestdemo.model.Person;
import com.abhijitkulkarni.personrestdemo.model.PersonList;
import com.abhijitkulkarni.personrestdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public PersonList getPersons() {
        return personService.getPersons();
    }

    @GetMapping(
            value = "/{id}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public Person getPerson(@PathVariable int id) throws PersonNotFoundException {
        return personService.getPerson(id);
    }

    @PutMapping(
            value = "/{id}",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public Person updatePerson(@PathVariable int id, @RequestBody Person person) throws PersonIncorrectException {
        return personService.updatePerson(id, person);
    }

    @PostMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable int id) throws PersonNotFoundException {
        personService.deletePerson(id);
    }
}
