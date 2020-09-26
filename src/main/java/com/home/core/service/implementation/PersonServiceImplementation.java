package com.home.core.service.implementation;

import com.home.core.model.Person;
import com.home.core.repository.PersonRepository;
import com.home.core.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

public class PersonServiceImplementation implements IPersonService {


    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImplementation(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getPersonById(int idPerson) {
        return personRepository.findById(idPerson);
    }

    @Override
    public String savePerson(Person person) {
        personRepository.save(person);
        return "Complete saved";
    }
}
