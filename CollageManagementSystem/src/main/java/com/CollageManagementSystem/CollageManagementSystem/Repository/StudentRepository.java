package com.CollageManagementSystem.CollageManagementSystem.Repository;

import com.CollageManagementSystem.CollageManagementSystem.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
}
