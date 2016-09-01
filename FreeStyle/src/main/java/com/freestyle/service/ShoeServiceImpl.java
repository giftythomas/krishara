package com.freestyle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freestyle.dao.ShoeDAO;
import com.freestyle.model.Product;

@Service
public class ShoeServiceImpl implements ShoeService {

	@Autowired
	ShoeDAO shoeDAO;
	
	public List<Product> getByCategory(String category) {
		List<Product> list=shoeDAO.getByCategory(category);
		return list;
	}	
}
