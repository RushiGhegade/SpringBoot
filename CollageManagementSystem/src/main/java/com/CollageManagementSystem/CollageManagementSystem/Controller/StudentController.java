package com.CollageManagementSystem.CollageManagementSystem.Controller;

import com.CollageManagementSystem.CollageManagementSystem.DTO.ProfessorDTO;
import com.CollageManagementSystem.CollageManagementSystem.DTO.StudentDTO;
import com.CollageManagementSystem.CollageManagementSystem.GlobalResponseSend.ApiResponse;
import com.CollageManagementSystem.CollageManagementSystem.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "Student/")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllUser(){
        List<StudentDTO> result = studentService.getAllUser();
        return new ResponseEntity<>(new ApiResponse(result), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO result = studentService.addStudent(studentDTO);

        return new ResponseEntity<>(new ApiResponse(result), HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "{stdId}/professor/{proId}")
    public ResponseEntity<ApiResponse> assignProfessorToStudent(@PathVariable int stdId,@PathVariable int proId){

        StudentDTO result= studentService.assignProfessorToStudent(stdId,proId);
        return new ResponseEntity<>(new ApiResponse(result), HttpStatus.ACCEPTED);
    }
}
