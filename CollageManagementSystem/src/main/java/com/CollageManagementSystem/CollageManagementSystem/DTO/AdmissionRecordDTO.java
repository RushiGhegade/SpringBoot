package com.CollageManagementSystem.CollageManagementSystem.DTO;

import com.CollageManagementSystem.CollageManagementSystem.Entity.StudentEntity;
import lombok.*;


public class AdmissionRecordDTO {

    private int id;

    private double fees;

    private StudentEntity student;

    public AdmissionRecordDTO() {
    }

    public AdmissionRecordDTO(int id, double fees, StudentEntity student) {
        this.id = id;
        this.fees = fees;
        this.student = student;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
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
//    private StudentDTO student;
}
