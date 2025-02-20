package com.TableMapping.TableMapping.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(
        name = "DepartmentTable",
        uniqueConstraints = {
                @UniqueConstraint(name = "name_unique",columnNames = "name")
        }
)
public class DPTEntity {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DPTEntity dptEntity = (DPTEntity) o;
        return id == dptEntity.id && Objects.equals(name, dptEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    @OneToOne
    @JoinColumn(name = "manager")
    EmployeeEntity manager;

    @OneToMany(mappedBy = "workerdpt",fetch = FetchType.EAGER)
    @JsonIgnore
    Set<EmployeeEntity> Workers;


    public DPTEntity() {
    }

    public DPTEntity(int id, String name, EmployeeEntity manager, Set<EmployeeEntity> workers) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        Workers = workers;
    }

    public Set<EmployeeEntity> getWorkers() {
        return Workers;
    }

    public void setWorkers(Set<EmployeeEntity> workers) {
        Workers = workers;
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

    public EmployeeEntity getManager() {
        return manager;
    }

    public void setManager(EmployeeEntity manager) {
        this.manager = manager;
    }


}
