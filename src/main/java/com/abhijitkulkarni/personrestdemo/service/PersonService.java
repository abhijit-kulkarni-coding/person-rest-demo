package com.abhijitkulkarni.personrestdemo.service;

import com.abhijitkulkarni.personrestdemo.exception.error.PersonIncorrectException;
import com.abhijitkulkarni.personrestdemo.exception.error.PersonNotFoundException;
import com.abhijitkulkarni.personrestdemo.model.Person;
import com.abhijitkulkarni.personrestdemo.model.PersonList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private int lastId = 1;
    private final List<Person> personList = new ArrayList<>();

    public PersonList getPersons() {
        PersonList listOfPersons = new PersonList();
        listOfPersons.getPersonList().addAll(this.personList);
        listOfPersons.setCount(this.personList.size());
        return listOfPersons;
    }

    public Person createPerson(Person person) {
        Person createdPerson = new Person();
        createdPerson.setId(lastId++);
        createdPerson.setFirstName(person.getFirstName());
        createdPerson.setLastName(person.getLastName());
        personList.add(createdPerson);
        return createdPerson;
    }

    public Person getPerson(int id) throws PersonNotFoundException {
        Optional<Person> person = personList.stream().filter(p -> p.getId() == id).findFirst();
        if (person.isPresent()) {
            return person.get();
        } else {
            throw new PersonNotFoundException("Id or person not found for fetch.");
        }
    }

    public Person updatePerson(int id, Person person) throws PersonIncorrectException {
        Person personToUpdate = personList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        if (personToUpdate != null && personToUpdate.getId() == id && personToUpdate.getId() == person.getId()) {
            personToUpdate.setFirstName(person.getFirstName());
            personToUpdate.setLastName(person.getLastName());
        } else {
            throw new PersonIncorrectException("Id or person info is incorrect for updation.");
        }
        return personToUpdate;
    }

    public void deletePerson(int id) throws PersonNotFoundException {
        boolean deleted = false;
        for (Person p : personList) {
            if (id == p.getId()) {
                personList.remove(p);
                deleted = true;
                break;
            }
        }
        if (deleted == false) {
            throw new PersonNotFoundException("Id or person not found for deletion.");
        }
    }
}
