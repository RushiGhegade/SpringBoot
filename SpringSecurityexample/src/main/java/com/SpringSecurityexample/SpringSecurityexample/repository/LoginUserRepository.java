package com.SpringSecurityexample.SpringSecurityexample.repository;

import com.SpringSecurityexample.SpringSecurityexample.entity.LoginUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUserEntity,Integer> {


    Optional<LoginUserEntity> findByEmail(String username);
}
