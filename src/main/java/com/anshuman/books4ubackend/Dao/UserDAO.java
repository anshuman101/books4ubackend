package com.anshuman.books4ubackend.Dao;

import java.util.List;

import com.anshuman.books4ubackend.model.User;

public interface UserDAO {

	public boolean saveUser(User user);
	public boolean updateUser(User user);
	public User getUserByUserName(String Username);
	public boolean deleteUser(User user);
	public List<User> getAllUsers();
	public boolean validateUser(String username,String password);
}
