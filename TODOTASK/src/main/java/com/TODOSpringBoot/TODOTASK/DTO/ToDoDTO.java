package com.TODOSpringBoot.TODOTASK.DTO;


import org.springframework.stereotype.Component;

@Component
public class ToDoDTO {
    Integer id;
    String name ;
    String discription;
    String date;
    Boolean isCompleted;

    public ToDoDTO(){}

    public ToDoDTO( Integer id,String name ,String discription,String date,Boolean isCompleted){
        this.id=id;
        this.name=name;
        this.discription=discription;
        this.date = date;
        this.isCompleted=isCompleted;
    }


    // Setter and Getter
    public void setId(int id){
        this.id=id;
    }
    public Integer getId(){
        return this.id;
    }
    public void setname(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setDiscription(String discription){
        this.discription=discription;
    }
    public String getDiscription(){
        return this.discription;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getDate(){
        return this.date;
    }
    public void setIsCompleted(Boolean isCompleted){
        this.isCompleted=isCompleted;
    }
    public Boolean getIsCompleted(){
        return this.isCompleted;
    }

}
