package com.collaboration.service;

import java.util.List;

import com.collaboration.model.Blog;

public interface BlogService {
	public void createNewBlog(Blog blog);

	public List<Blog> getBlogList(String bUserName);

	public Blog getBlogById(int bid);

	public Blog getBlogByName(String bname);

	public List<Blog> getBlog();

}
