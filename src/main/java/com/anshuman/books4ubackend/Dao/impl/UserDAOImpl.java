package com.anshuman.books4ubackend.Dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anshuman.books4ubackend.Dao.UserDAO;
import com.anshuman.books4ubackend.model.User;

@Repository(value="userDAO")
@Transactional

public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean saveUser(User user) {
	 try {
		sessionFactory.getCurrentSession().save(user);
	} catch (HibernateException e) {
			return false;
	}
	 
	return true;	
	}

	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (HibernateException e) {
			
			return false;
		}
		return true;
	}

	public User getUserByUserName(String Username) {
		User user=(User) sessionFactory.getCurrentSession().get(User.class, Username);
			return(user);	
	}

	public boolean deleteUser(User user) {
		try {
			user = sessionFactory.getCurrentSession().load(User.class, user.getUsername());
			sessionFactory.getCurrentSession().delete(user);
		} catch (HibernateException e) {
			
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		//hql query since referencing from class(Users)
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@SuppressWarnings("unchecked")
	public boolean validateUser(String username, String password) {
		//to give value at start
		String hql ="from User where username='"+username+"' and password='"+password+"'";
		//to give value at end
		//String hql="from User where Username=? and password=?";
		
		Query<User> query = sessionFactory.getCurrentSession().createQuery(hql);
		User user = query.uniqueResult();
		//to get a single user(since username is primary key
		
		if(user!=null)
			return true;
		return false;
	}
	

}
