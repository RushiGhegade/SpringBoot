package com.StudentdatabaseAdvance.Studentdatabase.Controller;

import com.StudentdatabaseAdvance.Studentdatabase.Service.ServiceProvider;
import com.StudentdatabaseAdvance.Studentdatabase.StudentDTO.StudentDTO;
import com.StudentdatabaseAdvance.Studentdatabase.advice.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/Student")
public class StudentController {

    private ServiceProvider serviceProvider;

    public StudentController(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @GetMapping(path = "/Test")
    public ResponseEntity<String> StudentTestDb(){
        return ResponseEntity.ok(serviceProvider.StudentTestDb());
    }

    @GetMapping(path = "/GetUserById/{id}")
    public ResponseEntity<StudentDTO> getUserById(@PathVariable Integer id){

           Optional<StudentDTO> studentDTO =  serviceProvider.getUserById(id);

           return studentDTO.map(
                   studentDTO1 -> ResponseEntity.ok(studentDTO1)
           ).orElseThrow(()-> new ResourceNotFoundException("Not found user id "+id));
    }

//    // We Handel it using Local Level
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handelException(NoSuchElementException obj){
//        return new ResponseEntity<>("Student Not Found",HttpStatus.NOT_FOUND);
//    }

    @GetMapping(path = "/GetAllUser")
    public ResponseEntity<List<StudentDTO>> getAllUser(){
        return ResponseEntity.ok(serviceProvider.getAllUser());
    }

    @PostMapping(path = "/AddUser")
    public ResponseEntity<StudentDTO>  addUser(@Valid @RequestBody StudentDTO studentDTO){

        StudentDTO studentDTO1 =  serviceProvider.addUser(studentDTO);

        return new ResponseEntity<>(studentDTO1 , HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateData(@PathVariable Integer id , @RequestBody StudentDTO studentDTO){
        return  serviceProvider.updateData(id,studentDTO);
    }

    @PatchMapping("/updatedataSpecific/{id}")
    public ResponseEntity<StudentDTO> updatedataSpecific(@PathVariable Integer id , @RequestBody Map<String,Object> studentInfo){
        return serviceProvider.updatedataSpecific(id,studentInfo);
    }

}
