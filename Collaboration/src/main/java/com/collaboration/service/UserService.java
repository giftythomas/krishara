package com.collaboration.service;

import java.util.*;
import com.collaboration.model.*;
public interface UserService
{
	public void saveOrUpdate(User user);
	public User getUserById(int userid);
	public  List<User> list();
	public User getUserByname(String username);
	//public boolean login(String username , String password);

}
