package com.teste.concepts.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {


    @GetMapping
    public ResponseEntity<String> teste(){
        return  ResponseEntity.ok("esta no ar");
    }


}
