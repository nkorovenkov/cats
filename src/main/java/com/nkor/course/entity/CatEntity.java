package com.nkor.course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cats")
public class CatEntity extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "mass")
    private int weight;

    public CatEntity(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public CatEntity() {
    }
}
