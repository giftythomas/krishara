package com.freestyle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freestyle.dao.UserDAO;
import com.freestyle.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	public String addUser(User user) {
		System.out.println("User service");
		return userDAO.addUser(user);
		
	}
	
	public List<User> viewUser() {

		List<User>list= userDAO.viewUser();
		return list;
	}

	
	public User getUserByName(String name) {
		return userDAO.getUserByName(name);
	}

	
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
		
	}
	
}
