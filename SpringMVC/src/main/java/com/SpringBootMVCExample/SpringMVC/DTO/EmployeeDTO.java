package com.SpringBootMVCExample.SpringMVC.DTO;


public class EmployeeDTO {
    private Integer id ;
    private String name;
    private String email;
    private Integer sal;
    private Boolean isWorking;

    public EmployeeDTO() {}

    EmployeeDTO(Integer id , String name , String email , Integer sal , Boolean isWorking){
        this.id = id;
        this.name = name;
        this.email =email;
        this.sal =sal;
        this.isWorking=isWorking;
    }

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
