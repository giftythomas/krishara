package com.collaboration.service;
import java.util.*;
import  com.collaboration.dao.*;
import com.collaboration.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserSerivceImpl implements UserService
{
	@Autowired
	private UserDaoInterface userdao;
	
	@Transactional
	public void setUserDao(UserDaoInterface userdao)
	{
		this.userdao=userdao;
	}

	@Transactional
	public void saveOrUpdate(User user) {
		userdao.saveOrUpdate(user);
		
	}

	@Transactional
	public User getUserById(int userid) {
		
		return userdao.getUserById(userid);
	}

	@Transactional
	public List<User> list() {
		
		return userdao.list();
	}

	@Transactional
	public User getUserByname(String username) {
		
		return userdao.getUserByname(username);
	}
	
	/*@Transactional
	public boolean  login(String username , String password)
	{
		return userdao.login(username, password);
	}*/
	
}
