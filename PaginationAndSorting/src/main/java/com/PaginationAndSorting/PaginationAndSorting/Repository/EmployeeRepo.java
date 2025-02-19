package com.PaginationAndSorting.PaginationAndSorting.Repository;

import com.PaginationAndSorting.PaginationAndSorting.employeeEntity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer> {

    List<EmployeeEntity> findBy(Sort sortBy);

    Page<EmployeeEntity> findAll(Pageable pageable);
}
