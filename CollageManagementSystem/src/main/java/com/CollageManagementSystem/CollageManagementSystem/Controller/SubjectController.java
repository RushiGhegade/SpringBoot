package com.CollageManagementSystem.CollageManagementSystem.Controller;

import com.CollageManagementSystem.CollageManagementSystem.DTO.SubjectDTO;
import com.CollageManagementSystem.CollageManagementSystem.GlobalResponseSend.ApiResponse;
import com.CollageManagementSystem.CollageManagementSystem.Service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping(path = "Subject/")
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping
    ResponseEntity<ApiResponse> getAllProfessor(){

        List<SubjectDTO> result = subjectService.getAllsubject();
        return new ResponseEntity<>(new ApiResponse(result), HttpStatus.ACCEPTED);
    }

    @PostMapping
    ResponseEntity<ApiResponse> addSubject(@RequestBody SubjectDTO subjectDTO){
        SubjectDTO result = subjectService.addSubject(subjectDTO);
        return new ResponseEntity<>(new ApiResponse(result), HttpStatus.ACCEPTED);
    }

    @PutMapping(path = "{subId}/professor/{proId}")
    ResponseEntity<ApiResponse> assignProfessorToSubject(@PathVariable int subId , @PathVariable int proId){

        SubjectDTO result = subjectService.assignProfessorToSubject(subId,proId);
        return new ResponseEntity<>(new ApiResponse(result), HttpStatus.ACCEPTED);

    }
}
