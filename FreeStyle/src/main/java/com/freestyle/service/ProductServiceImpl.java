package com.freestyle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freestyle.dao.ProductDAO;
import com.freestyle.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO productDAO;
	
	public void addProduct(Product product) {
		System.out.println("Product service");
		productDAO.addProduct(product);
		
	}
	
	public List<Product> viewProduct() {

		List<Product>list= productDAO.viewProduct();
		return list;
	}

	
	public void deleteProduct(int id) {
		System.out.println("delete service");
		productDAO.deleteProduct(id);
		
	}

	
	public Product getId(int id) {
		Product product=productDAO.getId(id);
		return product;
	}

	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
		
	}
	
}
