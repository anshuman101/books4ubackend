package com.anshuman.books4ubackend.Dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anshuman.books4ubackend.Dao.ProductDAO;
import com.anshuman.books4ubackend.model.Product;


@Repository(value="productDAO")  //subclass of component ie this is available everywhere
@Transactional
public class ProductDAOImpl implements ProductDAO {

	
	
	@Autowired 
	SessionFactory sessionfactory;
	
	public boolean saveProduct(Product product) {
		try {
			sessionfactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
			return false;
		}
		
	}

	public Product getProductById(int id) {
		
		return sessionfactory.getCurrentSession().get(Product.class, id);   
		//inside get Product.class is where we have to perform to get the id
		//id is what we have to get from product class
	}
	//wherever boolean put a try catch
	public boolean deleteProduct(Product product) {
		try {
			sessionfactory.getCurrentSession().delete(product);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean updateProduct(Product product) {
		try {
			sessionfactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	public List<Product> getAllProducts() {
		return sessionfactory.getCurrentSession().createQuery("from Product").list();
	}

}
