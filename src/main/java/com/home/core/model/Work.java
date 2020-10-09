package com.home.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "work")
public class Work {

    @Id
    private String idWork;
    private String nameWork;
    private Long priceWork;
    private String descriptionWork;
    private boolean enableWork;
}
