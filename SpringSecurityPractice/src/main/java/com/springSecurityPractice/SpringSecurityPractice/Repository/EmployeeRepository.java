package com.springSecurityPractice.SpringSecurityPractice.Repository;


import com.springSecurityPractice.SpringSecurityPractice.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {


}
