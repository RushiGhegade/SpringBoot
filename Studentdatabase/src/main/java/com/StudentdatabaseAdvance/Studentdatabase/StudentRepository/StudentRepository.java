package com.StudentdatabaseAdvance.Studentdatabase.StudentRepository;

import com.StudentdatabaseAdvance.Studentdatabase.StudentEntity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{

}
