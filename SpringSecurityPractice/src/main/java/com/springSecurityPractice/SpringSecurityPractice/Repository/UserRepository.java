package com.springSecurityPractice.SpringSecurityPractice.Repository;

import com.springSecurityPractice.SpringSecurityPractice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {


    Optional<UserEntity> findByEmail(String username);
}
