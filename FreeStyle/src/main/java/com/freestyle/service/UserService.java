package com.freestyle.service;

import java.util.List;

import com.freestyle.model.User;

public interface UserService {

   public String addUser(User user);
   
   public List<User> viewUser();
   
   public User getUserByName(String name);
   
   public void deleteUser(int id);
	
}
