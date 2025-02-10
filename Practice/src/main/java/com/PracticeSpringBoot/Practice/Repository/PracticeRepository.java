package com.PracticeSpringBoot.Practice.Repository;

import com.PracticeSpringBoot.Practice.Entity.PracticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticeRepository extends JpaRepository<PracticeEntity,Integer> {

}
