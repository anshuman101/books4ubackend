/*package com.anshuman.books4ubackend;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anshuman.books4ubackend.Dao.UserDAO;
import com.anshuman.books4ubackend.model.User;

public class UserJUnitTest {

	//for testing ( important)
	
	@Autowired
	static private AnnotationConfigApplicationContext context;
	//Autowired creates auto instance i.e for automatic creation
	@Autowired
	static private UserDAO userDAO;
	
	@Autowired
	static private User user;
	
	//before class gets executed this method(under Before Class) gets execute
	@BeforeClass
	static public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.anshuman.books4ubackend");
		context.refresh();
		user = (User) context.getBean("user");
		userDAO=(UserDAO)context.getBean("userDAO");
		
	}
	
	@Ignore
	//this below annotation makes the below declared method a test method
	@Test
	public void testToAddUser()
	{
		user.setUsername("bot2");//wont work since user is a primary key
		user.setAddress("Shalimar Nagar");
		user.setEmail("bot2@gmail.com");
		user.setPassword("123456");
		user.setRole("seller");
		user.setMobile("8447");
		user.setActive(true);		//assertequals make comparison between what we get and what is expected.
		//i.e true is expecyed and user. method is passed
		assertEquals(true,userDAO.saveUser(user));
			
	}
	//ignore is added to ignore a test case
	@Ignore
	@Test(expected=PersistenceException.class)
	public void testToAddUserforFailure()
	{
		user.setUsername("bot1");//wont work since user is a primary key
		user.setAddress("Krishna Nagar");
		user.setEmail("bot1@gmail.com");
		user.setPassword("123456");
		user.setRole("user");
		user.setMobile("9811");
		user.setActive(true);		
		assertEquals(false,userDAO.saveUser(user));
			
	}
	
	//now make unit testiong for each of the methods 
	@Ignore
	@Test
	public void testforDeletion()
	{
		user.setUsername("bot2");
		user.setAddress("Shalimar Nagar");
		user.setEmail("bot2@gmail.com");
		user.setPassword("123456");
		user.setRole("seller");
		user.setMobile("8447");
		user.setActive(true);
		assertEquals(true, userDAO.deleteUser(user));
		
	}
	@Ignore
	@Test(expected=EntityNotFoundException.class)
	public void testforDeletionforFailure()
	{
		user.setUsername("bot3");//wont work since user is a primary key
		user.setAddress("Krna Nagar");
		user.setEmail("bot@gmail.com");
		user.setPassword("123456");
		user.setRole("");
		user.setMobile("");
		user.setActive(true);
		assertEquals(false, userDAO.deleteUser(user));
		
	}
	@Ignore
	@Test
	public void testforUpdateUser()
	{
		user.setUsername("bot2");
		user.setAddress("Rohini");
		user.setEmail("bot2updated@gmail.com");
		user.setPassword("123456");
		user.setRole("seller");
		user.setMobile("8007");
		user.setActive(true);
		assertEquals(true,userDAO.updateUser(user));
	}
	@Ignore
	@Test(expected=PersistenceException.class)
	public void testforUpdateUserforFailure()
	{
		user.setUsername("bot3");
		user.setAddress("Rohini");
		user.setEmail("bot2updated@gmail.com");
		user.setPassword("123456");
		user.setRole("seller");
		user.setMobile("8007");
		user.setActive(true);
		assertEquals(true,userDAO.updateUser(user));
	}
	@Ignore
	@Test
	public void testforUserValidation()
	{
		user.setUsername("bot1");
		user.setPassword("123456");
		assertEquals(true, userDAO.validateUser(user.getUsername(), user.getPassword()));
		//assertfalse or asserttrue can be used in place of assertequals
	}
	@Ignore
	@Test(expected=IllegalArgumentException.class)
	public void testforUserValidationforFailure()
	{
		//lambda expressions(came in jdk 1.8)
		
		//we iterate for each user here
		List <User> userlist= userDAO.getAllUsers();
		userlist.forEach((tempUser)->{
			assertEquals(true, userDAO.validateUser(tempUser.getUsername(), tempUser.getPassword()));

		});
	}
	@Ignore
	@Test
	public void testforgettingUsersByUsername()
	{
		user.setUsername("bot2");
		user.setAddress("Rohini");
		user.setEmail("bot2updated@gmail.com");
		user.setPassword("123456");
		user.setRole("seller");
		user.setMobile("8007");
		user.setActive(true);
		assertEquals(user,userDAO.getUserByUserName("bot2"));
	}
	@Ignore
	@Test
	public void testforgettingUsersByUsernameforfailure()
	{
		user.setUsername("bot2");
		user.setAddress("Rohini");
		user.setEmail("bot2updated@gmail.com");
		user.setPassword("123456");
		user.setRole("seller");
		user.setMobile("8007");
		user.setActive(true);
		assertNotEquals(user,userDAO.getUserByUserName("bot1"));
		//checks if not equal both these
	}

	@Test
	public void testtogetAllUsers(){
		
		assertNotNull(userDAO.getAllUsers());
		
	}
	
}

*/