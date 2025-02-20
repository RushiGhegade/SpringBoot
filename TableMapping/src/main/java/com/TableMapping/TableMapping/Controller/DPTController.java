package com.TableMapping.TableMapping.Controller;

import com.TableMapping.TableMapping.Entity.DPTEntity;
import com.TableMapping.TableMapping.Entity.EmployeeEntity;
import com.TableMapping.TableMapping.Service.DPTService;
import org.springframework.web.bind.annotation.*;
import  java.util.*;
@RestController
@RequestMapping("/Department")
public class DPTController {

    DPTService dptService;

    public DPTController(DPTService dptService) {
        this.dptService = dptService;
    }

    @PostMapping("/AddDepartment")
    public DPTEntity addEmployee(@RequestBody DPTEntity dptEntity){

        return dptService.addEmployee(dptEntity);

    }

    @PutMapping("/addManager/{dptId}/manager/{empId}")
    public DPTEntity addManager(@PathVariable int dptId , @PathVariable int empId){

        return dptService.AddManager(dptId,empId);

    }

    @GetMapping("/GetData")
    public List<DPTEntity> getDepartment(){

        return dptService.GetDepartment();
    }
}
