package com.springSecurityPractice.SpringSecurityPractice.service;

import com.springSecurityPractice.SpringSecurityPractice.Repository.EmployeeRepository;
import com.springSecurityPractice.SpringSecurityPractice.dto.EmployeeDTO;
import com.springSecurityPractice.SpringSecurityPractice.entity.EmployeeEntity;
import com.springSecurityPractice.SpringSecurityPractice.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public String TestServer() {
        return "Server Tested Successfully";
    }

    public List<EmployeeDTO> getAllEmployee() {

        List<EmployeeEntity> employeeEntity  =  employeeRepository.findAll();

        return employeeEntity
                .stream()
                .map(
                        employee -> modelMapper.map(employee, EmployeeDTO.class)
                ).toList();

    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {

        EmployeeEntity employeeEntity =  modelMapper.map(employeeDTO,EmployeeEntity.class);

        EmployeeEntity employee =  employeeRepository.save(employeeEntity);

        return modelMapper.map(employee, EmployeeDTO.class);

    }

    public EmployeeDTO getEmployeeById(Integer id) {

        EmployeeEntity employee =  employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee Not Found With id "+id)
        );

        return  modelMapper.map(
                employee, EmployeeDTO.class
        );
    }
}
