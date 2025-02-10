package com.projectstructure.Project_Structure_MVC.Controller;

import com.projectstructure.Project_Structure_MVC.DTO.DTOclass;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Student")
public class controllerclass {

    // This are the GetMapping Reqests

    @GetMapping(path = "/")
    public String  getdata(){
        return "Data Send Sucessfully";
    }

    @GetMapping(path = "/roll")
    public int  getroll(){
        return 10;
    }

    @GetMapping("/find/{name}")
    public String get(@PathVariable(name = "name") String id){
        return id;
    }

    // PostMapping

    @PostMapping("/adddata")
    public String add(){
        return "Hello From Me!";
    }

    @PostMapping("/addme")
    public DTOclass send(@RequestBody DTOclass obj){
        return obj;
    }

    // Put Mapping
    @PutMapping("/putmapping/{id}")
    public String putdata(@PathVariable Integer id){
        return "Data Update Sucessfully At Id "+id;
    }

    // Delete Mapping
    @DeleteMapping("/deleteMapping/{getid}")
    public String deleteMapping(@PathVariable(name = "getid") Integer id){
        return "Data Delete Sucessfully At Id " +id ;
    }

    // Patch Mapping
    @PatchMapping("/PatchMapping/{id}")
    public String patchMapping(@PathVariable String id){
        return "Data Patch Sucessfullt At Id "+id;
    }


}
