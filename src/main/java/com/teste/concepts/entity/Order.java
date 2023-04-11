package com.teste.concepts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.http.fileupload.ThresholdingOutputStream;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 7049055161180447685L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_order", nullable = false)
    private Long id;

    private Instant instant;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "cod_usuario")
    private User user;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();


    public Order(Long id, Instant instant, OrderStatus orderStatus, User user) {
        this.id = id;
        this.instant = instant;
        this.orderStatus = orderStatus;
        this.user = user;
    }
    public Set<OrderItem> getItems() {
        return items;
    }
    public BigDecimal getTotal(){
        return this.getItems().stream().map(t -> t.getPrice()).reduce(BigDecimal.ZERO , BigDecimal::add);
    }


}
