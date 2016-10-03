package com.freestyle.dao;

import java.util.List;

import org.springframework.binding.message.MessageContext;

import com.freestyle.model.User;


public interface UserDAO {

	public String addUser(User user);
	
	public List<User> viewUser();
	
	public User getUserByName(String name);
	
	public void deleteUser(int id);
	
	public String validateUser(User user,MessageContext messageContext);
	
}
