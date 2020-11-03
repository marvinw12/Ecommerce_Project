package com.tts.ecommerce.service;

import java.util.List;

import com.tts.ecommerce.models.Product;
import com.tts.ecommerce.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public List<String> findDistinctCategories(){
        return ""
    }




}