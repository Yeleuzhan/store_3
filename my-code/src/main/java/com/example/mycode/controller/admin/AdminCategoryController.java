package com.example.mycode.controller.admin;

import com.example.mycode.model.Category;
import com.example.mycode.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/category")
public class AdminCategoryController {

    private CategoryService categoryService;

    public AdminCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> getAll() {
        List<Category> categories = categoryService.getAll();
        return categories;
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable(name = "id") Long id) {
        Category category = categoryService.getById(id);
        return category;
    }

    @PostMapping("/add")
    public Category add(@RequestBody Category category) {
        Category category1 = categoryService.add(category);
        return category1;
    }

}
