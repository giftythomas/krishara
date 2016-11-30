package com.fsfbackend.testcases;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fsfbackend.dao.SupplierDAO;
import com.fsfbackend.model.Supplier;

public class SupplierTest {

	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDAO supplierDAO;
	static AnnotationConfigApplicationContext config;
	
	@Before
	public void init(){
		config = new AnnotationConfigApplicationContext();
		config.scan("com.fsfbackend");
		config.refresh();
		supplier= (Supplier) config.getBean("supplier");
		supplierDAO= (SupplierDAO) config.getBean("supplierDAO");
		
	}
	@Test
	public void test() {
		supplier.setSupAddress("Bangalore");
		supplier.setSupName("Hilarious");
		supplierDAO.saveOrUpdate(supplier);
	}

}
