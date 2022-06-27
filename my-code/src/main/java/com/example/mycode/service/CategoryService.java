package com.example.mycode.service;

import com.example.mycode.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category getById(Long id);

    Category add(Category category);

}
