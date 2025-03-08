package com.CollageManagementSystem.CollageManagementSystem.Entity;

import com.CollageManagementSystem.CollageManagementSystem.DTO.AdmissionRecordDTO;
import com.CollageManagementSystem.CollageManagementSystem.DTO.ProfessorDTO;
import com.CollageManagementSystem.CollageManagementSystem.DTO.SubjectDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "StudentTable")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    // ---------------------- One To One Mapping ----------------------

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonIgnore
    private AdmissionRecordEntity admissionRecordDTO;

    @ManyToMany
    @JoinTable(
            name = "Professor_student_Mapping",
            joinColumns =  @JoinColumn(name = "professors"),
            inverseJoinColumns = @JoinColumn(name = "students")
    )
    List<ProfessorEntity> professors;

    public StudentEntity(int id, String name, AdmissionRecordEntity admissionRecordDTO) {
        this.id = id;
        this.name = name;
        this.admissionRecordDTO = admissionRecordDTO;
    }

    public StudentEntity() {

    }

    public List<ProfessorEntity> getProfessors() {
        return professors;
    }

    public void setProfessors(List<ProfessorEntity> professors) {
        this.professors = professors;
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

    public AdmissionRecordEntity getAdmissionRecordDTO() {
        return admissionRecordDTO;
    }

    public void setAdmissionRecordDTO(AdmissionRecordEntity admissionRecordDTO) {
        this.admissionRecordDTO = admissionRecordDTO;
    }

    //    List<ProfessorDTO> professor;

//    List<SubjectDTO> subjects;
}
