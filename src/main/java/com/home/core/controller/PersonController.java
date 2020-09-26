package com.home.core.controller;

import com.home.core.model.Person;
import com.home.core.repository.PersonRepository;
import com.home.core.service.implementation.PersonServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    PersonRepository personRepository;

    //public PersonServiceImplementation personServiceImplementation;

    @GetMapping("/getpersons")
    public List<Person> getAllPerson(){
        return personRepository.findAll();
        //return personServiceImplementation.getAllPerson();
    }

    @PostMapping("/saveperson")
    public String savePerson(@RequestBody Person person){
        personRepository.save(person);
        return "save completed";
        //return personServiceImplementation.savePerson(person);

    }
}
