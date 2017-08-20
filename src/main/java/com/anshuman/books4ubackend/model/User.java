package com.anshuman.books4ubackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="user_data")

// to save the objects state easily
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "users")
	private String username;
	private boolean active;  //check if user registered or not
	@Column(nullable = false)
	private String password;
	private String address;
	@Column(nullable = false)
	private String email;
	private String mobile;
	@Column(nullable = false)
	private String role; //define if user is admin,seller or buyer
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public boolean equals(Object obj) {
		//override since normal compares only reference, so for different objects cant be compared
		
		if(this==null||obj==null)
			return false;
		if(this.getClass()!=obj.getClass()) //both objects have different classes
			return false;
		else
		{
			//here obj is of object type we change it to user type
			User actual = (User) obj;
			if(this.username.compareTo(actual.getUsername())!=0)
				//if two things compared then answer =0 then equal else notequal
				return false;
			if(this.password.compareTo(actual.getPassword())!=0)
				return false;
			if(this.email.compareTo(actual.getEmail())!=0)
				return false;
			if(this.role.compareTo(actual.getRole())!=0)
				return false;
			
		}
		
		
		return true;
	}
	
	
}
