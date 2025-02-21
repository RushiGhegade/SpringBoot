package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.controller;

import com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Dto.PutDTO;
import com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.putService.PutService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Data
@RestController
@RequestMapping(path = "/Employee")
public class PutController {


    private final PutService putService;

    public PutController(PutService putService) {
        this.putService = putService;
    }

    @GetMapping
    public List<PutDTO> getAllUser(){
        return putService.getAllUser();
    }

    @PostMapping(path = "/addUser", produces = "application/json")
    public PutDTO createUser(@RequestBody PutDTO putDTO){
        return putService.createUser(putDTO);
    }

    @GetMapping(path = "{id}")
    public PutDTO getUserById(@PathVariable int id){

        return putService.findUserById(id);

    }

}
