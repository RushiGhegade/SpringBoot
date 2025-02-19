package com.PaginationAndSorting.PaginationAndSorting.EmployeeService;

import com.PaginationAndSorting.PaginationAndSorting.Repository.EmployeeRepo;
import com.PaginationAndSorting.PaginationAndSorting.employeeEntity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public EmployeeEntity addUser(EmployeeEntity employeeEntity) {

        EmployeeEntity employeeEntity1 = employeeRepo.save(employeeEntity);

        return employeeEntity1;
    }

    public List<EmployeeEntity> getAllUser() {

        return employeeRepo.findAll();

    }

    public List<EmployeeEntity> getAllUserSortByAge(Sort sortBy) {

        List<EmployeeEntity> list = employeeRepo.findBy(sortBy);

        return list;

    }

    public List<EmployeeEntity> getpageWiseData(Pageable pageable) {

        return  employeeRepo.findAll(pageable).getContent();

    }
}
