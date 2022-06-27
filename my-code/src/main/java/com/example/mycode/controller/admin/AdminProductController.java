package com.example.mycode.controller.admin;

import com.example.mycode.dto.product.AddProductRequest;
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

    public AdminProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public Product add(@RequestBody AddProductRequest addProductRequest) {
        Product product1 = productService.add(addProductRequest);
        return product1;
    }

}
