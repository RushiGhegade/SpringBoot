package com.HabiernateAndJpaPractice.HibdernetAndJpa;

import com.HabiernateAndJpaPractice.HibdernetAndJpa.Entity.ProductEntity;
import com.HabiernateAndJpaPractice.HibdernetAndJpa.ProductRepository.ProdectRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;
@SpringBootTest
class HibdernetAndJpaApplicationTests {

	@Autowired
	ProdectRepo prodectRepo;

	@Test
	void contextLoads() {
		System.out.println("Hello");
	}

//	@Test
//	void TestRepo(){
//
//		ProductEntity productEntity = ProductEntity.builder().sku("Nestle1234").title("Chocolate").price(3.4).quantity(4).build();
//
//		ProductEntity saveEntity = prodectRepo.save(productEntity);
//
//		System.out.println(saveEntity);
//
//	}

	// findUserBy Title
//	@Test
//    void getUserById(){

		// Search For a Specific Entry

//		List<ProductEntity> productEntities1 = prodectRepo.findBytitle("Chocolate");
//		List<ProductEntity> productEntities1 = prodectRepo.findBySku("Nestle123");
//		List<ProductEntity> productEntities1 = prodectRepo.findByQuantity(4);

		// Search Assending and Desending

//		List<ProductEntity> productEntities1 = prodectRepo.findAllByOrderByQuantity();
//		List<ProductEntity> productEntities1 = prodectRepo.findAllByOrderByQuantityDesc();

		// For Search Query

//		List<ProductEntity> productEntities1 = prodectRepo.findByTitleContains("maza");

		// Using Logical Operators
//		List<ProductEntity> productEntities1 = prodectRepo.findByTitleAndSku("Chocolate","kitkat9999");

		// when And Both side is having and then we make it like this
//		List<ProductEntity> productEntities1 = prodectRepo.findByIdAndSku(43,"kitkat");


		// gretter then Query
//		List<ProductEntity> productEntities1 = prodectRepo.findByPriceGreaterThanOrPrice (20,20);
//
//		System.out.println(productEntities1);
//
//
//
//	}

}
