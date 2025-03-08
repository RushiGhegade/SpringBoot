package com.AllSpringSecurity.SpringSecurity.controller;

import com.AllSpringSecurity.SpringSecurity.service.StudentService;
import com.AllSpringSecurity.SpringSecurity.studentdto.StudentDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan("com.AllSpringSecurity.SpringSecurity")
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String TestServer(){
        return "Server Tested Sucessfully";
    }

    @GetMapping("/getInfo")
    public List<StudentDTO> getInfo(){

        return  studentService.getUserInfo();

    }

    @PostMapping()
    public StudentDTO addUser(@RequestBody StudentDTO studentDTO){

        return studentService.addUser(studentDTO);

    }

}
