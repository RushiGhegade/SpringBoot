package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Entity;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;


@Entity
@Table(
        name = "BasicSetUp"
)
@Audited
public class putEntity extends AuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int putid;

    String name;

    String description;

    public putEntity(int id, String name, String description) {
        this.putid = id;
        this.name = name;
        this.description = description;
    }

    public putEntity() {
    }

    public int getPutid() {
        return putid;
    }

    public void setPutid(int putid) {
        this.putid = putid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
