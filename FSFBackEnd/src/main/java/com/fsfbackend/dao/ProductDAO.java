package com.fsfbackend.dao;

import java.util.List;

import com.fsfbackend.model.Product;

public interface ProductDAO {

	public List<Product> list();
	
	public Product get(int id);
	
	public boolean saveOrUpdate(Product product);
	
	public void delete(int id);
}
