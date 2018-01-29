package com.sannu.categoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sannu.categoryservice.model.Category;

public interface CategoryRepositorty extends JpaRepository<Category, Long> {	
	Category findByName(String name);
}