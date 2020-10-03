package com.home.core.repository;

import com.home.core.model.ContactForm;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormRepository extends MongoRepository<ContactForm,String> {
}
