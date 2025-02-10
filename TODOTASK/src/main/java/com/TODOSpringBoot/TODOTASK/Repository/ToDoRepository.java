package com.TODOSpringBoot.TODOTASK.Repository;

import com.TODOSpringBoot.TODOTASK.Entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<TodoEntity , Integer> {

}
