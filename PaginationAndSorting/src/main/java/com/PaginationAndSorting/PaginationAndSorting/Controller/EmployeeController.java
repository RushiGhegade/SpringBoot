package com.PaginationAndSorting.PaginationAndSorting.Controller;

import com.PaginationAndSorting.PaginationAndSorting.EmployeeService.EmployeeService;
import com.PaginationAndSorting.PaginationAndSorting.employeeEntity.EmployeeEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/TestServer")
    public String TextServer(){
        return "Server Tested Sucessfully";
    }

    @PostMapping("/AddEmployee")
    public EmployeeEntity AddEmployee(@RequestBody EmployeeEntity employeeEntity){

        return employeeService.addUser(employeeEntity);

    }

    @GetMapping("/GetAllUser")
    public List<EmployeeEntity> getAllUser(){

        List<EmployeeEntity> getdata = employeeService.getAllUser();

        return getdata;

    }

    //  get Sortby age
    @GetMapping("/GetUserSortBy")
    public List<EmployeeEntity> getAllUserSortByAge(@RequestParam(defaultValue = "age") String sortByName){

        Sort sortBy = Sort.by(Sort.Direction.DESC,sortByName);

        List<EmployeeEntity> getdata = employeeService.getAllUserSortByAge(sortBy);

        return getdata;

    }

    // getdata PageWise
    @GetMapping(path = "/getUserData")
    public List<EmployeeEntity> getpageWiseData(){

        Pageable pageable = PageRequest.of(0,3,Sort.by(Sort.Direction.DESC,"age"));

        return employeeService.getpageWiseData(pageable);

    }

}
