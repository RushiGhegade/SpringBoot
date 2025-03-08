package com.CollageManagementSystem.CollageManagementSystem.DTO;

import com.CollageManagementSystem.CollageManagementSystem.Entity.ProfessorEntity;
import lombok.*;

import java.util.List;


public class SubjectDTO {

    private int  id;

    private String name;

    private ProfessorEntity professor;

    public SubjectDTO() {
    }

    public SubjectDTO(int id, String name, ProfessorEntity professor) {
        this.id = id;
        this.name = name;
        this.professor = professor;
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
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

    //    private ProfessorDTO professor;

//    List<StudentDTO> students;
}
