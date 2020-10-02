package com.home.core.controller;

import com.home.core.model.ContactForm;
import com.home.core.repository.ContactFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contact-form")
public class ContactFormController {

    @Autowired
    ContactFormRepository contactFormRepository;

    @GetMapping
    public List<ContactForm> getAllContactForm(){
        return contactFormRepository.findAll();
    }

    @GetMapping("/{idForm}")
    public Optional<ContactForm> getContactForm(@PathVariable String idForm){
        return contactFormRepository.findById(idForm);
    }

    @PostMapping
    public String sendContactForm(@RequestBody ContactForm contactForm){
        contactFormRepository.save(contactForm);
        return "Contact form sended";
    }



}
