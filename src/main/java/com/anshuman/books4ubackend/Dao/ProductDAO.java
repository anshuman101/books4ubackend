package com.anshuman.books4ubackend.Dao;

import java.util.List;

import com.anshuman.books4ubackend.model.Product;

public interface ProductDAO {

		public boolean saveProduct(Product product);
		
		public Product getProductById(int id);    //to retrieve a product as per id
		
		public boolean deleteProduct(Product product);
		
		public boolean updateProduct(Product product);
		
		public List<Product> getAllProducts();
		
}
