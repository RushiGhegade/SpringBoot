package com.CollageManagementSystem.CollageManagementSystem.Repository;

import com.CollageManagementSystem.CollageManagementSystem.Entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity,Integer> {
}
