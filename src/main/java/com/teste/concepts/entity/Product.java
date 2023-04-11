package com.teste.concepts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_produto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_produto", nullable = false)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private String imgUrl;

    @ManyToMany
    @JoinColumn(name = "cod_categoria")
    @JoinTable(name = "ta_produto_category",
            joinColumns = @JoinColumn(name = "cod_produto"),
            inverseJoinColumns = @JoinColumn(name = "cod_categoria")
    )
    private Set<Category> categories = new HashSet<>();

    public Product(Long id, String name, String description, BigDecimal price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }
}
