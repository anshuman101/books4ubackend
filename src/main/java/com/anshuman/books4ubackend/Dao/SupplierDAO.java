package com.anshuman.books4ubackend.Dao;

import java.util.List;

import com.anshuman.books4ubackend.model.Supplier;

public interface SupplierDAO {

	public boolean saveSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public Supplier getSupplierBySupplierId(int supplierId);
	public boolean deleteSupplier(Supplier supplier);
	public List<Supplier> getAllSuppliers();
	
}
