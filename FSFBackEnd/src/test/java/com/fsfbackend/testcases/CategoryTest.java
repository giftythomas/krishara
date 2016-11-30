package com.fsfbackend.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fsfbackend.dao.CategoryDAO;
import com.fsfbackend.model.Category;

public class CategoryTest {
	
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	Category category;
	static AnnotationConfigApplicationContext config;
	@Before
	public void init(){
		config =new AnnotationConfigApplicationContext();
		config.scan("com.fsfbackend");
		config.refresh();
		category=(Category) config.getBean("category");
		categoryDAO=(CategoryDAO) config.getBean("categoryDAO");
	}

	@Test
	public void saveOrUpdate() {
		category.setCatDescription("Dope");
		category.setCatName("Brand");
		categoryDAO.saveOrUpdate(category);
	}
	
	@Test
	public void get(){
		int size=categoryDAO.list().size();
		assertEquals("category list is", 2, size);
	}

	@Test
	public void delete(){
		categoryDAO.delete(2);
	}
}
