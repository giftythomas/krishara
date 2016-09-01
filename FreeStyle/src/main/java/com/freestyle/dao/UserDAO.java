package com.freestyle.dao;

import java.util.List;

import com.freestyle.model.User;


public interface UserDAO {

	public void addUser(User user);
	
	public List<User> viewUser();
	
	public User getUserByName(String name);
	
	public void deleteUser(int id);
	
}
