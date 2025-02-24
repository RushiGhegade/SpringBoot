package com.RestClient.RestClient;

import com.RestClient.RestClient.Dto.PutDTO;

import com.RestClient.RestClient.client.EmployeeClient;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RestClientApplicationTests {

	@Test
	void test(){
		System.out.println("Hello");
	}

	@Autowired
	private EmployeeClient employeeClient;

	@Test
	@Order(3)
	void getAllUser(){
		List<PutDTO> getUsrs = employeeClient.getAllUser();

		System.out.println("Get All User");
		System.out.println(getUsrs.toString());
	}

	@Test
	@Order(1)
	void createUser(){

		PutDTO putDTO = new PutDTO(1,"Rushikesh Ghegade","He is working on Backend part");

		PutDTO addUser = employeeClient.createUser(putDTO);

		System.out.println("Add User");
		System.out.println(addUser);

	}

	@Test
	@Order(2)
	void getUserById(){

//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Enter the id Which You want to find");
//		int id =sc.nextInt();

		PutDTO putDTO = employeeClient.getUserById(6);
		System.out.println("Find User By Id");
		System.out.println(putDTO);

	}


	@Test
	@Order(3)
	void putUser(){
		PutDTO putDTO = new PutDTO(6,"shriram khade","He is working on frontend part");
		PutDTO update = employeeClient.updateUserById(6,putDTO);

		System.out.println(update);

	}



}
