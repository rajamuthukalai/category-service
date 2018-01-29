package com.sannu.categoryservice.service;

import java.util.List;

import com.sannu.categoryservice.exception.CategoryNotFoundException;
import com.sannu.categoryservice.model.Category;

public interface CategoryService {
	List<Category> getCategories();
	Category getCategory(Long id) throws CategoryNotFoundException;
	Category getCategory(String name);
	Category createCategory(Category category);
	Category updateCategory(Category category);
	boolean deleteCategory(Long id) throws CategoryNotFoundException;
}