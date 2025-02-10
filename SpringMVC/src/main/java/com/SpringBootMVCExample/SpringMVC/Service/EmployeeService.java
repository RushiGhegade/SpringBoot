package com.SpringBootMVCExample.SpringMVC.Service;

import com.SpringBootMVCExample.SpringMVC.DTO.EmployeeDTO;
import com.SpringBootMVCExample.SpringMVC.EmployeeEntity.EmployeeEntity;
import com.SpringBootMVCExample.SpringMVC.EmployeeRepository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository ;
    private final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository , ModelMapper modelMapper){
        this.employeeRepository=employeeRepository;

        this.modelMapper=modelMapper;
    }

    public List<EmployeeDTO> findAllEmp() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        return employeeEntities.stream().map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class)).collect(Collectors.toList());
    }


    public EmployeeDTO getData(Integer id){
        System.out.println("Servoce Layer Call "+id);

        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);

        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO addEmp(EmployeeDTO employeeDTO) {

        EmployeeEntity togetEmpEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);

        EmployeeEntity employeeEntity = employeeRepository.save(togetEmpEntity);

        return modelMapper.map(employeeEntity,EmployeeDTO.class);

    }
}
