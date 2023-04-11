package com.teste.concepts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

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

    @ManyToOne
    @JoinColumn(name = "cod_categoria")
    private Category categories;

}
