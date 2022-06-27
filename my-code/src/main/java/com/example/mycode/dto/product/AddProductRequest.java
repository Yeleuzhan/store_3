package com.example.mycode.dto.product;

import lombok.Data;

@Data
public class AddProductRequest {

    private String name;

    private String description;

    private Double price;

    private Long categoryId;

}
