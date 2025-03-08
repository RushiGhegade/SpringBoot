package com.CollageManagementSystem.CollageManagementSystem.Entity;

import com.CollageManagementSystem.CollageManagementSystem.DTO.StudentDTO;
import com.CollageManagementSystem.CollageManagementSystem.DTO.SubjectDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ProfessorTable")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "professor")
    @JsonIgnore
    private List<SubjectEntity> subjects;

    @ManyToMany(mappedBy = "professors",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<StudentEntity> students;

    public ProfessorEntity() {
    }

    public ProfessorEntity(int id, String name, List<SubjectEntity> subjects) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorEntity that = (ProfessorEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
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

    public List<SubjectEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectEntity> subjects) {
        this.subjects = subjects;
    }


}

