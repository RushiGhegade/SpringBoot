package com.AllSpringSecurity.SpringSecurity.entity;

import jakarta.persistence.*;

//
@Entity
@Table(name = "StudentDatabase")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    int age;

    public StudentEntity() {
    }

    public StudentEntity(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
