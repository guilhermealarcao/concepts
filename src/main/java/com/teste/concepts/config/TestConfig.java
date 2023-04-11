package com.teste.concepts.config;

import com.teste.concepts.entity.Category;
import com.teste.concepts.resources.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig implements CommandLineRunner {


    @Autowired
    private CategoryRespository categoryRespository;


    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "teste");

        categoryRespository.save(category1);


    }
}
