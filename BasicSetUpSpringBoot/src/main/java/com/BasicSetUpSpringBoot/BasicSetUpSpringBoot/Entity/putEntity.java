package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(
        name = "BasicSetUp"
)
public class putEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    String name;

    String description;

    public putEntity(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public putEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
