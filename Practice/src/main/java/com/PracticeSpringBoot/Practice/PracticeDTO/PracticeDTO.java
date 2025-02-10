package com.PracticeSpringBoot.Practice.PracticeDTO;

import com.PracticeSpringBoot.Practice.Config.CustomCheckPassword;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;


@Getter
@Setter
public class PracticeDTO {

    int id;
    String name;
    @Positive(message = "Age Must Be Positive")
    int age;
    double cgpa;
    String grade;
    @CustomCheckPassword
    String password;

    public PracticeDTO() {
    }

    public PracticeDTO(int id, String name, int age, double cgpa, String grade,String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
        this.grade = grade;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

