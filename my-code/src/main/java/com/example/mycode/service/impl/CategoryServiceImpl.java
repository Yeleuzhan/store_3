package com.example.mycode.service.impl;

import com.example.mycode.exception.ResourceNotFoundException;
import com.example.mycode.model.Category;
import com.example.mycode.repository.CategoryRepository;
import com.example.mycode.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
    }

    @Override
    public Category add(Category category) {
        return categoryRepository.save(category);
    }
}
