package com.freestyle.service;

import java.util.List;

import com.freestyle.model.Supplier;

public interface SupplierService {

	public void addSupplier(Supplier supplier);
	List<Supplier> listSupplier();
	public void deleteSupplier(int id);
	public Supplier getSupplier(int id);
}
