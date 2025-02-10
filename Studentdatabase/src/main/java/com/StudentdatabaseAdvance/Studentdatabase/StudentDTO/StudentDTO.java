package com.StudentdatabaseAdvance.Studentdatabase.StudentDTO;


import com.StudentdatabaseAdvance.Studentdatabase.CustomAnotation.CustomAnotationdeclare;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class StudentDTO {

    Integer id ;

    @NotBlank(message = "Name Not have Blank")
    String name;

//    @Email(message = "Not valid Email")
    @Pattern(regexp = ".*@gmail\\.com$")
    String email;

    @NotBlank(message = "It not have blank")
    String collageName;

    @Max(value = 10,message = "Not have gretter then 10")
    @Min(value = 0,message = "Cgpa Greter then 0")
    double cgpa;

    @Negative(message = "mark gretter then 0")
    Integer mark;

    @Future(message = "not Valid")
    LocalDate Addmisiondate;

    @CustomAnotationdeclare(message = "it not coorect")
    String grad;

    boolean isPresent;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, String name, String collageName, double cgpa, String grad, boolean isPresent,String email,Integer mark,LocalDate Addmisiondate) {
        this.id   = id;
        this.name = name;
        this.collageName = collageName;
        this.cgpa = cgpa;
        this.grad = grad;
        this.isPresent = isPresent;
        this.email=email;
        this.mark =mark;
        this.Addmisiondate=Addmisiondate;
    }

    public LocalDate getAddmisiondate() {
        return Addmisiondate;
    }

    public void setAddmisiondate(LocalDate addmisiondate) {
        Addmisiondate = addmisiondate;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
