package com.HabiernateAndJpaPractice.HibdernetAndJpa.ProductRepository;

import com.HabiernateAndJpaPractice.HibdernetAndJpa.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdectRepo extends JpaRepository<ProductEntity,Integer> {

    List<ProductEntity> findBytitle(String chco);

    List<ProductEntity> findBySku(String chocolate);

    List<ProductEntity> findByQuantity(Integer quantity);


    List<ProductEntity> findAllByOrderByQuantity();

    List<ProductEntity> findAllByOrderByQuantityDesc();

//    List<ProductEntity> findByTitleContaining(String title);

    List<ProductEntity> findByTitleContains(String maza);

    List<ProductEntity> findByTitleAndSku(String maza, String kitkat);

    List<ProductEntity> findByIdAndSku(int i, String kitkat);

    List<ProductEntity> findByPriceGreaterThanOrPrice(int i, int i1);
}
