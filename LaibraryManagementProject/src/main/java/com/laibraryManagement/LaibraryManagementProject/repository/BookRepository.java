package com.laibraryManagement.LaibraryManagementProject.repository;

import com.laibraryManagement.LaibraryManagementProject.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {

}
