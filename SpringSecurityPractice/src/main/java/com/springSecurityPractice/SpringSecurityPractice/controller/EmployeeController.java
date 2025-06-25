package com.springSecurityPractice.SpringSecurityPractice.controller;

import com.springSecurityPractice.SpringSecurityPractice.dto.EmployeeDTO;
import com.springSecurityPractice.SpringSecurityPractice.responseHandler.ApiResponse;
import com.springSecurityPractice.SpringSecurityPractice.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping(path = "employee/")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> TestServer(){
        String result  =  employeeService.TestServer();

        return ResponseEntity.ok(new ApiResponse(result));

    }

    @GetMapping(path = "getAllEmployee")
    public ResponseEntity<ApiResponse> getAllEmployee(){

        List<EmployeeDTO> result = employeeService.getAllEmployee();

        return ResponseEntity.ok(new ApiResponse(result));
    }

    @GetMapping("getEmployeeById/{id}")
    public ResponseEntity<ApiResponse> getEmployeeById(@PathVariable Integer id ){
        EmployeeDTO result =  employeeService.getEmployeeById(id);
        return ResponseEntity.ok(new ApiResponse(result));
    }

    @PostMapping(path = "addEmployee")
    public ResponseEntity<ApiResponse> addEmployee(@RequestBody EmployeeDTO employeeDTO){

        EmployeeDTO result = employeeService.addEmployee(employeeDTO);
        return ResponseEntity.ok(new ApiResponse(result));
    }
}
