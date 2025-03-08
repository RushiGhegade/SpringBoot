package com.CollageManagementSystem.CollageManagementSystem.DTO;

import com.CollageManagementSystem.CollageManagementSystem.Entity.SubjectEntity;
import lombok.*;
import java.util.*;

public class ProfessorDTO {
    private int id;

    private String name;

    private List<SubjectEntity> subjects;

    public ProfessorDTO() {
    }

    public ProfessorDTO(int id, String name, List<SubjectEntity> subjects) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
    }

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
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

    //    List<SubjectDTO> subjects;

//    List<StudentDTO> students;
}
