package com.fsfbackend.dao;

import java.util.List;

import com.fsfbackend.model.User;

public interface UserDAO {

	public List<User> list();
	
	public boolean saveOrUpdate(User user);
	
	public void delete(int id);
	
	public User get(int id);
	
	public boolean validUser(String username, String password);
}
