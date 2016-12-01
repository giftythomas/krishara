package com.fsfbackend.testcases;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fsfbackend.dao.UserDAO;
import com.fsfbackend.model.User;

public class UserTest {

	@Autowired
	 UserDAO userDAO;
	
	@Autowired
	 User user;
	
	static AnnotationConfigApplicationContext config;
	
	@Before
	public void init(){
		config = new AnnotationConfigApplicationContext();
		config.scan("com.fsfbackend");
		config.refresh();
		user= (User) config.getBean("user");
		userDAO= (UserDAO) config.getBean("userDAO");
		
	}
	@Test
	public void saveOrUpdate(){
		user.setAddress("Hyderabad");
		user.setEmail("abc@abc.com");
		user.setEnabled(true);
		user.setPassword("password");
		user.setUsername("abc");
		userDAO.saveOrUpdate(user);
	}
	//@Test
	public void delete(){
		userDAO.delete(1);
	}
	//@Test
	public void list(){
		int size=userDAO.list().size();
		assertEquals("user list is", 2, size);
	}

}
