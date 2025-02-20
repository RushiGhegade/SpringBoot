package com.TableMapping.TableMapping.Controller;

import com.TableMapping.TableMapping.Entity.DPTEntity;
import com.TableMapping.TableMapping.Entity.EmployeeEntity;
import com.TableMapping.TableMapping.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/AddEmployee")
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employeeEntity){

        return employeeService.addEmployee(employeeEntity);

    }

    // One To One Mapping

    @GetMapping("/GetEmployee")
    public List<EmployeeEntity> getEmployee(){
        return employeeService.getAllEmployee();
    }

    // assign worker

    @PutMapping("/addworkers/{empId}/worker/{dptId}")
    public EmployeeEntity addWorkers(@PathVariable int empId , @PathVariable int dptId){

        return  employeeService.addWorkers(empId,dptId);

    }


}
