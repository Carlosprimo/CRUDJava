package com.caprimo.crud.controllers;

import com.caprimo.crud.models.Product;
import com.caprimo.crud.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductServices productServices;

    //Insert a product into database
    @PostMapping("/product")
    public ResponseEntity<Product> insertProduct(@RequestBody Product product){
        Product savedProduct =  productServices.insertProduct(product);
        return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
    }

    //Get a product by id
    @GetMapping("/product")
    public Product getProductById(@RequestParam("productId") Long productId){
        return productServices.getProductById(productId);
    }

    //get products by name using a row SQL statement
    @GetMapping("/product/name")
    public List<Product> getProductsByName(@RequestParam("productName") String productName){
        return productServices.getProductsByName(productName);
    }

    //Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productServices.getAllProducts();
    }
    //get a product by name


    //Update a product
    @PatchMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestParam("productId") Long productId,@RequestBody Product product){
        Product updatedProduct = productServices.updateProduct(product);
        return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
    }

    //Delete a product
    @DeleteMapping("/product")
    public ResponseEntity<Product> deleteProduct(@RequestParam("productId") Long productId){
        productServices.deleteProduct(productId);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }
}


