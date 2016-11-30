package com.fsfbackend.testcases;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fsfbackend.dao.ProductDAO;
import com.fsfbackend.model.Product;

public class ProductTest {

	@Autowired
	Product product;
	@Autowired
	ProductDAO productDAO;
	static AnnotationConfigApplicationContext config;
	
	@Before
	public void init(){
		config = new AnnotationConfigApplicationContext();
		config.scan("com.fsfbackend");
		config.refresh();
		product= (Product) config.getBean("product");
		productDAO= (ProductDAO) config.getBean("productDAO");
		
	}
	@Test
	public void saveOrUpdate() {
		product.setPrice(30000);
		product.setProDesc("Very Lame");
		product.setProName("Puma");
		productDAO.saveOrUpdate(product);
	}

}
