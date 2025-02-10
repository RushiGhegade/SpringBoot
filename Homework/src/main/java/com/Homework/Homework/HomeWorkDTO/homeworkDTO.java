package com.Homework.Homework.HomeWorkDTO;

import com.Homework.Homework.config.CheckPrimeNumber;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class homeworkDTO {

    int id;
    String name;

    @CheckPrimeNumber
    int age;
    String collageName;
    double cgpa;
    String grade;

    public homeworkDTO() {
    }

    public homeworkDTO(int id, String name, int age, String collageName, double cgpa, String grade) {
        System.out.println("in Dto constructor");
        this.id = id;
        this.name = name;
        this.age = age;
        this.collageName = collageName;
        this.cgpa = cgpa;
        this.grade = grade;
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

    public String getCollageName() {
        return collageName;
    }

    public void setCollageName(String collageName) {
        this.collageName = collageName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
