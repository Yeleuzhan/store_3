package com.example.mycode.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
public class OrderItem extends BaseEntity {

    private Long productId;

    private int productQuantity;

    private Double productPrice;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
