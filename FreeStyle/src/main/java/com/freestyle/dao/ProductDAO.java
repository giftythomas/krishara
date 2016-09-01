package com.freestyle.dao;

import java.util.List;

import com.freestyle.model.Product;


public interface ProductDAO {

	public void addProduct(Product product);
	
	public List<Product> viewProduct();
	
	public void deleteProduct(int id);
	
	public Product getId(int id);
	
	public void updateProduct(Product product);
}
