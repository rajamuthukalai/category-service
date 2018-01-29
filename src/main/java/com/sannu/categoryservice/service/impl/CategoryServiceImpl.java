package com.sannu.categoryservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sannu.categoryservice.exception.CategoryNotFoundException;
import com.sannu.categoryservice.model.Category;
import com.sannu.categoryservice.repository.CategoryRepositorty;
import com.sannu.categoryservice.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepositorty categoryRepository;

	@Override
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategory(Long id) throws CategoryNotFoundException {
		Category category = categoryRepository.findOne(id);
		if (category == null) {
			throw new CategoryNotFoundException(id);
		}
		return category;
	}

	@Override
	public Category getCategory(String name) {
		return categoryRepository.findByName(name);
	}

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public boolean deleteCategory(Long id) throws CategoryNotFoundException {
		boolean isDeleted = false;		
		try {
			Category category = categoryRepository.findOne(id);
			if (category == null) {
				throw new CategoryNotFoundException(id);
			}
			categoryRepository.delete(id);
			isDeleted = true;
		} catch (Exception e) {
			System.err.println("Exception occurred while deleting category with id: " + id);
		}
		return isDeleted;
	}
	
}