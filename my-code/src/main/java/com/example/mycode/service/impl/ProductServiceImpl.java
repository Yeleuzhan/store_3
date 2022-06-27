package com.example.mycode.service.impl;

import com.example.mycode.dto.product.AddProductRequest;
import com.example.mycode.exception.ResourceNotFoundException;
import com.example.mycode.mapper.CommonMapper;
import com.example.mycode.model.Category;
import com.example.mycode.model.Product;
import com.example.mycode.repository.ProductRepository;
import com.example.mycode.service.CategoryService;
import com.example.mycode.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;
    private CommonMapper commonMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, CommonMapper commonMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.commonMapper = commonMapper;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    }

    @Override
    public Product add(AddProductRequest addProductRequest) {
        Category category = categoryService.getById(addProductRequest.getCategoryId());
        Product product = commonMapper.convertTo(addProductRequest, Product.class);
        product.setCategory(category);
        return productRepository.save(product);
    }



}
