package com.fsfbackend.dao;

import java.util.List;

import com.fsfbackend.model.Category;

public interface CategoryDAO {

	public List<Category> list();
	
	public Category get(int id);
	
	public boolean saveOrUpdate(Category category);
	
	public void delete(int id);
	
	public Category getByName(String name);
}
