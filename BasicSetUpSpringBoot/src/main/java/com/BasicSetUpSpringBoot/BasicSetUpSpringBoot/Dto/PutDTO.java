package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Dto;


public class PutDTO {

    private int putid;

    private  String name;

    private  String description;

    public PutDTO(int id, String name, String description) {
        this.putid = id;
        this.name = name;
        this.description = description;
    }

    public PutDTO() {
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
