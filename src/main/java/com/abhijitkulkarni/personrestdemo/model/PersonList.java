package com.abhijitkulkarni.personrestdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonList {
    private List<Person> personList = new ArrayList<>();
    private int count = 0;
}
