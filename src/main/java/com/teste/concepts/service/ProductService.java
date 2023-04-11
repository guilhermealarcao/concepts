package com.teste.concepts.service;

import com.teste.concepts.entity.Category;
import com.teste.concepts.entity.Product;
import com.teste.concepts.repositories.CategoryRepository;
import com.teste.concepts.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository respository;

    public List<Product> findAll(){
        return respository.findAll();
    }

    public Product findById(Long id){
        return respository.findById(id).get();
    }

}
