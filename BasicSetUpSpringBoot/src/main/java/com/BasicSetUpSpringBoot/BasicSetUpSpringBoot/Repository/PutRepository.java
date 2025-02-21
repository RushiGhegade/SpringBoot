package com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Repository;

import com.BasicSetUpSpringBoot.BasicSetUpSpringBoot.Entity.putEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PutRepository extends JpaRepository<putEntity,Integer> {



}
