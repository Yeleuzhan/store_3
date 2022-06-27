package com.example.mycode.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity {

    private String email;

    private String password;

    private String name;

    private String phone;

    private String address;

    private String role = "ROLE_CUSTOMER";

    @OneToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

}
