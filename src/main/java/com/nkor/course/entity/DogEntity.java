package com.nkor.course.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;
@Getter
@Setter
@Document
public class DogEntity {
    @Id
    private UUID id;
    @Indexed(unique = true)
    private String name;
    private String age;
}
