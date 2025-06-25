package com.springSecurityPractice.SpringSecurityPractice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EmpInformationTable")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String position;

    private int age;

    private double sal;

    public EmployeeEntity() {
    }

    public EmployeeEntity(int id, String name, String position, int age, double sal) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.age = age;
        this.sal = sal;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}
