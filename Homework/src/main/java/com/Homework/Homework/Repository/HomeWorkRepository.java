package com.Homework.Homework.Repository;

import com.Homework.Homework.Entity.HomeWorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeWorkRepository extends JpaRepository<HomeWorkEntity,Integer> {


}
