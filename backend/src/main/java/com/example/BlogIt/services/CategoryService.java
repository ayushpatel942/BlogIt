package com.example.BlogIt.services;


import com.example.BlogIt.entities.Category;

import java.util.List;


public interface CategoryService {
    Category createCategory(Category category);
    Category updateCategory(Category category,Integer id);
    void deleteCategory(Integer id);
    Category getCategoryById(Integer id);
    List<Category> getAllCategories();
}