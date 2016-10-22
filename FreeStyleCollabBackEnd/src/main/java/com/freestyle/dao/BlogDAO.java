package com.freestyle.dao;

import java.util.List;

import com.freestyle.domainobject.Blog;

public interface BlogDAO {

	public boolean save(Blog blog);
	
	public boolean update(Blog blog);
	
	public List<Blog> listBlog();
	
	public Blog getBlog(int id);
}
