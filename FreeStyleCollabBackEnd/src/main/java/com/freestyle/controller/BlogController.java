package com.freestyle.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.freestyle.dao.BlogDAO;
import com.freestyle.domainobject.Blog;
import com.freestyle.domainobject.User;

@RestController
public class BlogController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	BlogDAO blogDAO;
	@GetMapping("/blog")
	public ResponseEntity<List<Blog>> listAllBlogs() {
		log.debug("<---Entering listAllBlogs method--->");
		List<Blog> blogs = blogDAO.listBlog();
		if (blogs.isEmpty()) {
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
	}
	@GetMapping(value="/blog/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> getBlog(@PathVariable("id") int id) {
		log.debug("<---Entering getBlog method--->");
		Blog blog=blogDAO.getBlog(id);
		if (blog == null) {
			blog=new Blog();
			blog.setErrorMessage("Blog does not exist with the given Id");
		}
		log.debug("<-- Got the blog with Id+ -->"+blog.getUser_id());
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	@PostMapping("/blog")
	public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog,HttpSession session) {
		log.debug("<---Entering saveBlog method--->");
		if (blogDAO.getBlog(blog.getId()) == null) {
			User loggedInUser=(User) session.getAttribute("loggedInUser");
			blog.setDate_time(new Date());
			blog.setStatus("N");
			blog.setUser_id(loggedInUser.getUser_id());
			blogDAO.save(blog);
			log.debug("<-- Blog is about to create --->");
			return new ResponseEntity<Blog>(blog, HttpStatus.CREATED);
		}
		log.debug("<---User already exists with user_id" + blog.getId());
		return new ResponseEntity<Blog>(blog, HttpStatus.CONFLICT);
	}
	@PutMapping("/blog/{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable("id") int id, @RequestBody User user) {
		log.debug("<---Entering updateBlog method--->");
		Blog blog=blogDAO.getBlog(id);
		if(blog==null){
			log.debug("<-- Blog about to update -->");
			return new ResponseEntity<Blog>(blog, HttpStatus.NOT_FOUND);
		}
		blogDAO.update(blog);
		log.debug("<---Blog updated successfully--->");
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}

}
