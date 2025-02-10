package com.TODOSpringBoot.TODOTASK.Controller;

import com.TODOSpringBoot.TODOTASK.DTO.ToDoDTO;
import com.TODOSpringBoot.TODOTASK.Entity.TodoEntity;
import com.TODOSpringBoot.TODOTASK.Repository.ToDoRepository;
import com.TODOSpringBoot.TODOTASK.Service.ToDoService;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Table(name="MyToDoTask")
@RequestMapping(path = "/ToDo")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @GetMapping(path = "/Test")
    public String ToDoTest(){
        return "TODO TEST SUCSSFULLY ";
    }

    @GetMapping(path="/{id}")
    public ToDoDTO findById(@PathVariable Integer id){
        return toDoService.findById(id);
    }

    @GetMapping(path = "/AllUser")
    public List<ToDoDTO> getAllUser(){
        return toDoService.findAll();
    }

    @PostMapping(path="/AddUser",produces = "application/json")
    public ToDoDTO  AddUSER(@RequestBody ToDoDTO toDoDTO){
        return toDoService.save(toDoDTO);
    }

    // for deleting the entry
    @DeleteMapping("/delete/{id}")
    public ToDoDTO delete(@PathVariable Integer id){

        return toDoService.deletebyid(id);

    }

    // Update the data inside Table
    @PutMapping("/updateUser/{id}")
    public ToDoDTO updateUser(@PathVariable Integer id,@RequestBody ToDoDTO obj){
        return toDoService.updateUser(id,obj);
    }

    // Patch the data inside Table
    @PatchMapping("/PatchUser/{id}")
    public ToDoDTO PatchUser(@PathVariable Integer id,@RequestBody ToDoDTO obj){
        return toDoService.updateUser(id,obj);
    }
}
