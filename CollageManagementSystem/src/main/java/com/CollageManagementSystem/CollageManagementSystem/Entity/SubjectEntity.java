package com.CollageManagementSystem.CollageManagementSystem.Entity;


import com.CollageManagementSystem.CollageManagementSystem.DTO.ProfessorDTO;
import com.CollageManagementSystem.CollageManagementSystem.DTO.StudentDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SubjectTable")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  id;


    private String name;

    // ---------------------- One To Many Mapping ----------------------

    @ManyToOne
    @JoinColumn(name = "professor")
    @JsonIgnore
    private ProfessorEntity professor;


    public SubjectEntity() {
    }

    public SubjectEntity(int id, String name, ProfessorEntity professor) {
        this.id = id;
        this.name = name;
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }



    //    List<StudentDTO> students;

}
