package com.example.mycode.controller.admin;

import com.example.mycode.model.Product;
import com.example.mycode.service.CategoryService;
import com.example.mycode.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/product")
public class AdminProductController {

    private ProductService productService;
    private CategoryService categoryService;

    public AdminProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public Product add(@RequestBody Product product) {

    }

}
