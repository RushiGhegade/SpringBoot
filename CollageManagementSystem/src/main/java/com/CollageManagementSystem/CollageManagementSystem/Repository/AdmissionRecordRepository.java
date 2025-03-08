package com.CollageManagementSystem.CollageManagementSystem.Repository;

import com.CollageManagementSystem.CollageManagementSystem.Entity.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity,Integer> {
}
