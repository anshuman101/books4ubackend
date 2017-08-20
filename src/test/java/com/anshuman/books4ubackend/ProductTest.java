package com.anshuman.books4ubackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anshuman.books4ubackend.Dao.ProductDAO;
import com.anshuman.books4ubackend.model.Product;

public class ProductTest {
	public static void main(String[] args)
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		//easily bean class can be refresh and used
		context.scan("com.anshuman.books4ubackend");
		
		context.refresh();
		
		Product product = (Product) context.getBean("product"); //"product" is the bean 
		product.setName("A collection Of shakespeare");
		product.setPrice(5000);
		product.setQuantity(100);
		product.setDescription("The best collection of bard of avon");
		
		
		ProductDAO dao=(ProductDAO)context.getBean("productDAO");
		if(dao.saveProduct(product)==true)
		System.out.println("The product was saved!!");
		else
		System.out.println("Unsaved Product");
		
		//Now we check whether the methods in DAO IMPL are being called correctly or not
		context.close();		
	
	}

}
