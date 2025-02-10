package com.TODOSpringBoot.TODOTASK.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Entity
@Table(name = "MyTable")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name ;
    String discription;
    String date;

    Boolean isCompleted;
    public TodoEntity(){}

    public TodoEntity( Integer id,String name ,String discription,String date,Boolean isCompleted){
        this.id=id;
        this.name=name;
        this.discription=discription;
        this.date = date;
        this.isCompleted=isCompleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
//

//
//
//    // Setter and Getter
//    public void setId(int id){
//        this.id=id;
//    }
//    public Integer getId(){
//        return this.id;
//    }
//    public void setname(String name){
//        this.name=name;
//    }
//    public String getName(){
//        return this.name;
//    }
//    public void setDiscription(String discription){
//        this.discription=discription;
//    }
//    public String getDiscription(){
//        return this.discription;
//    }
//    public void setDate(String date){
//        this.date=date;
//    }
//    public String getDate(){
//        return this.date;
//    }
//    public void setIsCompleted(Boolean isCompleted){
//        this.isCompleted=isCompleted;
//    }
//    public Boolean getIsCompleted(){
//        return this.isCompleted;
//    }
}
