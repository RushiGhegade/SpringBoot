package com.SpringBootMVCExample.SpringMVC.Controller;

import com.SpringBootMVCExample.SpringMVC.DTO.EmployeeDTO;
import com.SpringBootMVCExample.SpringMVC.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController( EmployeeService employeeService){
        this.employeeService=employeeService;
    }
//, produces = "application/json"
    @GetMapping(path="/FindEmpById/{id}")
    public EmployeeDTO getData(@PathVariable Integer id){

        System.out.println("Controller Layer Call "+id);
        return employeeService.getData(id);
    }

    @GetMapping(path="/FindEmpAll")
    public List<EmployeeDTO> findEmp() {
        System.out.println("Controller Layer Call ");
        return employeeService.findAllEmp();
    }

    @PostMapping(path="/AddEmp")
    public EmployeeDTO addEmp(@RequestBody EmployeeDTO employeeDTO){

        return employeeService.addEmp(employeeDTO);
    }
}
