package com.freestyle.service;

import java.util.List;

import com.freestyle.model.Product;

public interface ShoeService {

	public List<Product> getByCategory(String category);
	
}
