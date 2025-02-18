package com.HabiernateAndJpaPractice.HibdernetAndJpa.Controller;

import com.HabiernateAndJpaPractice.HibdernetAndJpa.Entity.ProductEntity;
import com.HabiernateAndJpaPractice.HibdernetAndJpa.ProductRepository.ProdectRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import  java.util.*;

@RestController
public class ControllerUser {

    ProdectRepo prodectRepo;

    public ControllerUser(ProdectRepo prodectRepo) {
        this.prodectRepo = prodectRepo;
    }

    @GetMapping("/getAllUser")
    public List<ProductEntity> getAllUser(){

        List<ProductEntity> productEntities = prodectRepo.findAll();

        return productEntities;

    }

}
