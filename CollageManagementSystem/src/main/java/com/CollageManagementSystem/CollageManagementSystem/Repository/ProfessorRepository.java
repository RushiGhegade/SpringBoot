package com.CollageManagementSystem.CollageManagementSystem.Repository;

import com.CollageManagementSystem.CollageManagementSystem.Entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity,Integer> {
}
