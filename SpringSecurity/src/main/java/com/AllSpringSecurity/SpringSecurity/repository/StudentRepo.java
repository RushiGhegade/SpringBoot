package com.AllSpringSecurity.SpringSecurity.repository;

import com.AllSpringSecurity.SpringSecurity.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {

}
