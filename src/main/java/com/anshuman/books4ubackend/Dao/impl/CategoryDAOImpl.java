package com.anshuman.books4ubackend.Dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anshuman.books4ubackend.Dao.CategoryDAO;
import com.anshuman.books4ubackend.model.Category;

@Repository(value="categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean saveCategory(Category category) {
		try{
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(HibernateException exception){
			exception.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(HibernateException excpetion){
			excpetion.printStackTrace();
		}
		return false;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, categoryId);
		return category;
	}

	@Override
	public boolean deleteCategory(Category category) {
		try{
			category = (Category) sessionFactory.getCurrentSession().load(Category.class, category.getCategoryId());
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(HibernateException exception){
			exception.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

}