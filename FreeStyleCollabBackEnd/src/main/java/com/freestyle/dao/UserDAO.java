package com.freestyle.dao;

import java.util.List;

import com.freestyle.domainobject.User;

public interface UserDAO {

	public boolean saveUser(User user);
	
	public boolean updateUser(User user);
	
	public void delete(int id);
	
	public User getById(int id);
	
	public List<User> listUser();
	
	public User authenticate(String name, String password);
	
}
