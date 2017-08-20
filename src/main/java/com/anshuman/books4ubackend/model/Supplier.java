package com.anshuman.books4ubackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="supplier_data")

public class Supplier implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int SupplierID;
	@Column(unique=true)//the value in this must be unique(not null too)
	private String companyName;
	@Column(nullable=false)//cant be null
	private String contactInfo;
	private String companyAdress;
	@Column(nullable=false)
	private String companyEmail;
	private boolean isActive;
	public int getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getCompanyAdress() {
		return companyAdress;
	}
	public void setCompanyAdress(String companyAdress) {
		this.companyAdress = companyAdress;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null || this == null)
			return false;
		if(this.getClass()!=obj.getClass())
			return false;
		else{
			Supplier actual = (Supplier) obj;
			if(this.SupplierID!=actual.getSupplierID())
				return false;
			if(this.companyName.compareTo(actual.getCompanyName())!=0)
				return false;
			if(this.companyAdress.compareTo(actual.getCompanyAdress())!=0)
				return false;
			if(this.companyEmail.compareTo(actual.getCompanyEmail())!=0)
				return false;
			if(this.isActive()!=actual.isActive())
				return false;
		}
		return true;
	}
}
	
