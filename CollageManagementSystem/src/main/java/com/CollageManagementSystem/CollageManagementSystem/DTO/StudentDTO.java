package com.CollageManagementSystem.CollageManagementSystem.DTO;

import com.CollageManagementSystem.CollageManagementSystem.Entity.ProfessorEntity;
import lombok.*;

import java.util.List;

public class StudentDTO {

    private int id;

    private String name;

    List<ProfessorEntity> professors;

    public StudentDTO(int id, String name, List<ProfessorEntity> professors) {
        this.id = id;
        this.name = name;
        this.professors = professors;
    }

    public List<ProfessorEntity> getProfessors() {
        return professors;
    }

    public void setProfessors(List<ProfessorEntity> professors) {
        this.professors = professors;
    }

    public StudentDTO() {
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
    //    List<ProfessorDTO> professor;

//    List<SubjectDTO> subjects;
}
