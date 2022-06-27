package com.example.mycode.service;

import com.example.mycode.dto.product.AddProductRequest;
import com.example.mycode.model.Product;

public interface ProductService {

    Product findById(Long id);

    Product add(AddProductRequest addProductRequest);

}
