package com.SpringBootMVCExample.SpringMVC.EmployeeRepository;

import com.SpringBootMVCExample.SpringMVC.EmployeeEntity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

}
