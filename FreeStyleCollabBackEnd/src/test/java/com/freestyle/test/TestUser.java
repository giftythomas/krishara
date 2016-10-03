package com.freestyle.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.freestyle.dao.UserDAO;
import com.freestyle.domainobject.User;

public class TestUser {

	@Autowired
	User user;
	@Autowired
	UserDAO userDAO;
	static AnnotationConfigApplicationContext context;
	@Before
	public void init(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.freestyle");
		context.refresh();
		user=(User) context.getBean("user");
		userDAO=(UserDAO) context.getBean("userDAO");
	}
	@Test
	public void testUpdateUser() {
		int size=userDAO.listUser().size();
		assertEquals("userlist is", 5, size);
	}

}
