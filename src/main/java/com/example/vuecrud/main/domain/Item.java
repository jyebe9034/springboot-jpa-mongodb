package com.example.vuecrud.main.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("vue_crud")
public class Item {

    @Id
    private String id;

    private String title;

    private String description;

    private Type type;

    private Boolean published;
}
