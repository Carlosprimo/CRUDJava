package com.caprimo.crud.dao;

import com.caprimo.crud.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product WHERE product_name = ?1", nativeQuery = true)
    List<Product> findByProductName(String productName);
}
