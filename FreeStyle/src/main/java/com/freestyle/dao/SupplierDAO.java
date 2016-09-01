package com.freestyle.dao;

import java.util.List;

import com.freestyle.model.Supplier;

public interface SupplierDAO {

	public void addSupplier(Supplier supplier);
	List<Supplier> listSupplier();
	public void deleteSupplier(int id);
	public Supplier getSupplier(int id);
}
