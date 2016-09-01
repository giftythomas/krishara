package com.freestyle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freestyle.dao.SupplierDAO;
import com.freestyle.model.Supplier;
@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierDAO supplierDAO;
	public void addSupplier(Supplier supplier) {
		supplierDAO.addSupplier(supplier);
		
	}

	
	public List<Supplier> listSupplier() {
		List<Supplier> list=supplierDAO.listSupplier();
		return list;
	}

	
	public void deleteSupplier(int id) {
		supplierDAO.deleteSupplier(id);
		
	}

	
	public Supplier getSupplier(int id) {
		Supplier supplier=supplierDAO.getSupplier(id);
		return supplier;
	}

}
