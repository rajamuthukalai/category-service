package com.sannu.categoryservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sannu.categoryservice.exception.CategoryNotFoundException;
import com.sannu.categoryservice.model.Category;
import com.sannu.categoryservice.model.CustomError;
import com.sannu.categoryservice.service.CategoryService;

@RestController
@RequestMapping(path = "/api/c")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping(path = "/categories")
	public List<Category> getCategories() {
		return categoryService.getCategories();
	}

	@GetMapping(path = "/category/{id}")
	public Category getBillers(@PathVariable(required = true) long id) throws CategoryNotFoundException {
		return categoryService.getCategory(id);
	}

	@PostMapping(path = "/category")
	public Category createCategory(@Valid @RequestBody Category category) {
		return categoryService.createCategory(category);
	}

	@PutMapping(path = "/category/{id}")
	public Category updateCategory(@Valid @RequestBody Category category) {
		return categoryService.updateCategory(category);
	}

	@DeleteMapping(path = "/category/{id}")
	public void deleteCategory(@PathVariable(required = true) Long id) throws CategoryNotFoundException {
		categoryService.deleteCategory(id);
	}

	@ExceptionHandler(CategoryNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomError categoryNotFound(CategoryNotFoundException e) {
		long categoryId = e.getCategoryId();
		return new CustomError(4, "Category [" + categoryId + "] not found");
	}

}