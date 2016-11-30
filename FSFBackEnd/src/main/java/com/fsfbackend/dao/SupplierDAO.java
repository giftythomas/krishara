package com.fsfbackend.dao;

import java.util.List;

import com.fsfbackend.model.Supplier;

public interface SupplierDAO {

	public List<Supplier> list();
	
	public void saveOrUpdate(Supplier supplier);
	
	public void delete(int id);
	
	public Supplier get(int id);
	
	public Supplier getByName(String name);
}
