package com.SpringSecurityexample.SpringSecurityexample.entity;


import jakarta.persistence.*;

@Entity
@Table(name ="UserInformationTable")
public class UserEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    String name;

    String email;

    String mobile;

    String loc;

    public UserEntity(int id, String name, String email, String mobile, String loc) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.loc = loc;
    }

    public UserEntity() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
