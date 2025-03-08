package com.CollageManagementSystem.CollageManagementSystem.Controller;

import com.CollageManagementSystem.CollageManagementSystem.DTO.ProfessorDTO;
import com.CollageManagementSystem.CollageManagementSystem.GlobalResponseSend.ApiResponse;
import com.CollageManagementSystem.CollageManagementSystem.Service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "Professor/")
public class ProfessorController {

    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
     ResponseEntity<ApiResponse> getAllProfessor(){

        List<ProfessorDTO> result = professorService.getAllProfessor();

        return new ResponseEntity<>(new ApiResponse(result), HttpStatus.ACCEPTED);
    }

    @PostMapping
    ResponseEntity<ApiResponse> addProfessor(@RequestBody ProfessorDTO professorDTO){
        ProfessorDTO result= professorService.addProfessor(professorDTO);
        return new ResponseEntity<>(new ApiResponse(result), HttpStatus.ACCEPTED);
    }
}
