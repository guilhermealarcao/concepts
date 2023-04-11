package com.teste.concepts.service;

import com.teste.concepts.entity.Category;
import com.teste.concepts.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository respository;

    public List<Category> findAll(){
        return respository.findAll();
    }

    public Category findById(Long id){
        return respository.findById(id).get();
    }

}
