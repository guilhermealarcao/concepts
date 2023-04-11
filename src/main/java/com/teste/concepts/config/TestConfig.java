package com.teste.concepts.config;

import com.teste.concepts.entity.*;
import com.teste.concepts.resources.CategoryRespository;
import com.teste.concepts.resources.OrderRepository;
import com.teste.concepts.resources.ProductRepository;
import com.teste.concepts.resources.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {


    @Autowired
    private CategoryRespository categoryRespository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {


        User user = new User(null, "guilherme", "teste@gmail.com", "55559922992258", "123");

        userRepository.save(user);

        Category category1 = new Category(null, "teste");
        Category category2 = new Category(null, "Mobile");

        categoryRespository.saveAll(Arrays.asList(category1, category2));


        Product product1 = new Product(null, "kibe", "kibe descrip", new BigDecimal("1002"), "tehusauhdhuahd");
        Product product2 = new Product(null, "kibe", "kibe descrip", new BigDecimal("1002"), "tehusauhdhuahd");

        product1.getCategories().add(category1);
        product1.getCategories().add(category2);

        productRepository.save(product1);


        var order = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, user);
        var order2 = new Order(null, Instant.now(), OrderStatus.DELIVERED, user);
        var order3 = new Order(null, Instant.now(), OrderStatus.PACKING, user);

        orderRepository.saveAll(Arrays.asList(order, order2, order3));


    }
}
