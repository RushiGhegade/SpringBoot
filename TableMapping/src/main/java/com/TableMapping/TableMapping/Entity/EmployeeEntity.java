package com.TableMapping.TableMapping.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;


@Entity
@Table(
        name = "EmployeeInformationTable"
)
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    @OneToOne(mappedBy = "manager",cascade = CascadeType.ALL)
    @JsonIgnore
    DPTEntity managedDpt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    DPTEntity workerdpt;

    public EmployeeEntity() {
    }

    public EmployeeEntity(int id, String name, DPTEntity managedDpt, DPTEntity workerdpt) {
        this.id = id;
        this.name = name;
        this.managedDpt = managedDpt;
        this.workerdpt = workerdpt;
    }

    public DPTEntity getWorkerdpt() {
        return workerdpt;
    }

    public void setWorkerdpt(DPTEntity workerdpt) {
        this.workerdpt = workerdpt;
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

    public DPTEntity getManagedDpt() {
        return managedDpt;
    }

    public void setManagedDpt(DPTEntity managedDpt) {
        this.managedDpt = managedDpt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
