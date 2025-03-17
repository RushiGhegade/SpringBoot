package com.SpringSecurityexample.SpringSecurityexample.repository;

import com.SpringSecurityexample.SpringSecurityexample.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity,Integer> {

}
