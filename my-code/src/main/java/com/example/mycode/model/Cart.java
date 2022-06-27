package com.example.mycode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart extends BaseEntity {

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private List<CartItem> cartItems;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    private double grandTotal;

}
