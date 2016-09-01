package com.freestyle.dao;

import java.util.List;

import com.freestyle.model.Product;

public interface ShoeDAO {

	public List<Product> getByCategory(String category);
}
