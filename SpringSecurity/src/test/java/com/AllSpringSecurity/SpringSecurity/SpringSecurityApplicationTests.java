package com.AllSpringSecurity.SpringSecurity;

import com.AllSpringSecurity.SpringSecurity.entity.UserEntity;

import com.AllSpringSecurity.SpringSecurity.service.JwtService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {

		UserEntity userEntity = new UserEntity(10,"Rushi","abc@gmail.com","1234");

		String token = jwtService.generateUserToken(userEntity);

		System.out.println(token);

		Integer id =  jwtService.generateUserIdFromToken(token);

		System.out.println(id);
	}

}
