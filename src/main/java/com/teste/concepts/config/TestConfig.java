package com.teste.concepts.config;

import com.teste.concepts.entity.Category;
import com.teste.concepts.entity.Order;
import com.teste.concepts.entity.Product;
import com.teste.concepts.entity.User;
import com.teste.concepts.resources.CategoryRespository;
import com.teste.concepts.resources.OrderRepository;
import com.teste.concepts.resources.ProductRepository;
import com.teste.concepts.resources.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.Instant;

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

        categoryRespository.save(category1);


        Product product1 = new Product(null, "kibe", "kibe descrip", new BigDecimal("1002"), "tehusauhdhuahd", category1);

        productRepository.save(product1);


        Order order = new Order(null, Instant.now(), user);

        orderRepository.save(order);


    }
}
