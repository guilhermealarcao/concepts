package com.teste.concepts.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Embeddable
public class OrderItemPk implements Serializable {

    private static final long serialVersionUID = 7049055161180447685L;

    @ManyToOne
    @JoinColumn(name = "cod_produto")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cod_order")
    private Order order;

}
