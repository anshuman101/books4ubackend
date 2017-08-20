package com.anshuman.books4ubackend;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anshuman.books4ubackend.Dao.CategoryDAO;
import com.anshuman.books4ubackend.model.Category;


public class CategoryJUnitTest {

	@Autowired
	private static AnnotationConfigApplicationContext context;

	@Autowired
	private static Category category;

	@Autowired
	private static CategoryDAO categoryDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.arjun.games4ubackend");
		context.refresh();

		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Ignore
	@Test
	public void testForAddingCategoryPass() {
		category.setCategoryName("one more new Category");
		category.setCategoryDescription("some decsription");
		category.setActive(true);

		assertTrue(categoryDAO.saveCategory(category));
	}

	@Test(expected = PersistenceException.class)
	public void testForAddingCategoryFail() {
		List<Category> categoryList = categoryDAO.getAllCategories();
		categoryList.forEach((categoryItem) -> {
			assertFalse(categoryDAO.saveCategory(categoryItem));
		});
	}

	@Test
	public void testForUpdatingCategoryPass() {
		category = categoryDAO.getAllCategories().get(0);
		category.setActive(!category.isActive());
		assertTrue(categoryDAO.updateCategory(category));
	}

	@Test(expected = PersistenceException.class)
	public void testForUpdatingCategoryFail() {
		category.setCategoryName("does not exists");
		category.setCategoryDescription("some decsription");
		category.setActive(true);

		assertFalse(categoryDAO.updateCategory(category));
	}

	@Test
	public void testForGetCategoryByIdPass() {
		List<Category> categoryList = categoryDAO.getAllCategories();
		categoryList.forEach((categoryItem) -> {
			assertEquals(categoryItem, categoryDAO.getCategoryById(categoryItem.getCategoryId()));
		});
	}

	@Test
	public void testForGetCategoryByIdFail() {
		List<Category> categoryList = categoryDAO.getAllCategories();
		categoryList.forEach((categoryItem) -> {
			assertNotEquals(categoryItem, categoryDAO.getCategoryById(categoryItem.getCategoryId() + 100));
		});
	}

	@Test
	public void testForGetAllCategories() {
		assertNotNull(categoryDAO.getAllCategories());
	}

	@Ignore
	@Test
	public void testForDeletingCategoryPass() {
		category = categoryDAO.getAllCategories().get(0);
		assertTrue(categoryDAO.deleteCategory(category));
	}

	@Test(expected = EntityNotFoundException.class)
	public void testForDeletingCategoryFail() {
		category.setCategoryId(200000);
		assertFalse(categoryDAO.deleteCategory(category));
	}

}