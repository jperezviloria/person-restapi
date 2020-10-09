package com.home.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "job")
public class Job {

    @Id
    private String idJob;
    private String nameJob;
    private String imageUrl;
    private String imageId;
    private int priceJob;
    private String descriptionJob;

}
