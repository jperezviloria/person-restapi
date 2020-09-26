package com.home.core.service;

import com.home.core.model.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    public List<Person> getAllPerson();

    public Optional<Person> getPersonById(int idPerson);

    public String savePerson(Person person);

}
