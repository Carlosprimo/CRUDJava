package com.caprimo.crud.services;

import com.caprimo.crud.dao.ProductDao;
import com.caprimo.crud.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class ProductServices {

    @Autowired
    private ProductDao productDao;

    public Product insertProduct(Product product) {
        return productDao.save(product);
    }

    public Product getProductById(Long id) {
        return productDao.findById(id).get();
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    public Product updateProduct(Product product) {
        Product productExist = productDao.findById(product.getId()).orElseThrow(() -> new RuntimeException("Product not found"));
        productExist.setProductName(product.getProductName());
        productExist.setColor(product.getColor());
        productExist.setPrice(product.getPrice());
        productDao.save(productExist);
        return productExist;
    }

    public Product deleteProduct(Long productId) {
        Product productExist = productDao.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        productDao.deleteById(productId);
        return productExist;
    }

    public List<Product> getProductsByName(String productName) {
        return productDao.findByProductName(productName);
    }
}
