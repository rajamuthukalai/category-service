package com.sannu.categoryservice.exception;

public class CategoryNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private long categoryId;

	public CategoryNotFoundException(long categoryId) {
		this.categoryId = categoryId;
	}
	
	public long getCategoryId() {
		return categoryId;
	}
}