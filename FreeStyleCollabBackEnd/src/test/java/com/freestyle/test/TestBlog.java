package com.freestyle.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.freestyle.dao.BlogDAO;
import com.freestyle.domainobject.Blog;

public class TestBlog {

	static AnnotationConfigApplicationContext context;
	@Autowired
	BlogDAO blogDAO;
	@Autowired
	Blog blog;
	@Before
	public void init(){
		context= new AnnotationConfigApplicationContext();
		context.scan("com.freestyle");
		context.refresh();
		blog=(Blog) context.getBean("blog");
		blogDAO=(BlogDAO) context.getBean("blogDAO");
	}
	@Test
	public void testSave() {
		Date date= new Date();
		blog.setTitle("Blog");
		blog.setDescription("Blog Description");
		blog.setDate_time(date);
		blogDAO.save(blog);
	}

}
