package com.freestyle.dao;

import java.util.List;

import com.freestyle.domainobject.User;

public interface UserDAO {

	public boolean saveUser(User user);
	
	public boolean updateUser(User user);
	
	public void delete(String id);
	
	public User getById(String id);
	
	public List<User> listUser();
	
	public void authenticate(User user);
	
}
