package com.CollageManagementSystem.CollageManagementSystem.Entity;

import com.CollageManagementSystem.CollageManagementSystem.DTO.StudentDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "AdmissionRecordTable")
public class AdmissionRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double fees;

    @OneToOne
    @JoinColumn(name = "student",unique = true)
    private StudentEntity student;

    public AdmissionRecordEntity(int id, double fees, StudentEntity student) {
        this.id = id;
        this.fees = fees;
        this.student = student;
    }

    public AdmissionRecordEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
