package com.anshuman.books4ubackend.Dao;

import java.util.List;

import com.anshuman.books4ubackend.model.Category;

public interface CategoryDAO {
	public boolean saveCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategoryById(int categoryId);
	public boolean deleteCategory(Category category);
	public List<Category> getAllCategories();
}