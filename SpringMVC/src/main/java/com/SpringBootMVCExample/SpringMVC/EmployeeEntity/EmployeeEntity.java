package com.SpringBootMVCExample.SpringMVC.EmployeeEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MyDatabaseTable")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    private String name;
    private String email;
    private Integer sal;
    private Boolean isWorking;

    public void setid(Integer id){
        this.id = id;
    }
    public Integer getid(){
        return this.id ;
    }

    public void setName(String  name){
        this.name = name;
    }
    public String getName(){
        return this.name ;
    }

    public void setEmail(String  email){
        this.email = email;
    }
    public String getEmail(){
        return this.email ;
    }
    public void setSal(Integer  sal){
        this.sal = sal;
    }
    public Integer getSal(){
        return this.sal ;
    }
    public void setIsWorking(Boolean  isWorking){
        this.isWorking = isWorking;
    }
    public Boolean getIsWorking(){
        return this.isWorking ;
    }


}
