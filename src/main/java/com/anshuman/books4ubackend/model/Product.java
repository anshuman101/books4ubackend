package com.anshuman.books4ubackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity   //for it to be auto created in a data base as table
@Component  //for it to be used anywhere(by objects)
@Table(name="Bought_Product")    //To opt for a table name change
public class Product {
		
	@Id                    //to set id as primary key//either we can auto generate id value or we can initialize every time
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Product_Id")  // alternate name for id column
	private int id;// to rename any column , simple put an annotation above it as above
	private String name;
	private String description;
	private double price;
	private int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
