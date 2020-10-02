package com.home.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "contactForm")
public class ContactForm {

    @Id
    private String idForm;
    private String nameForm;
    private int phoneForm;
    private String questionForm;
    private String particularServiceForm;

}
