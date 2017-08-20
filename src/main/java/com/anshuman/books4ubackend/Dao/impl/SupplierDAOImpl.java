package com.anshuman.books4ubackend.Dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anshuman.books4ubackend.Dao.SupplierDAO;
import com.anshuman.books4ubackend.model.Supplier;
import com.anshuman.books4ubackend.model.User;

@Repository(value="supplierDAO")  //subclass of component ie this is available everywhere
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionfactory ;	
	
	
	public boolean saveSupplier(Supplier supplier) {
		
		try {
			sessionfactory.getCurrentSession().save(supplier);
		} catch (HibernateException e) {
			return false;
		}
		
		return true;
	}

	public boolean updateSupplier(Supplier supplier) {
		
		try {
			sessionfactory.getCurrentSession().update(supplier);
		} catch (HibernateException e) {
			return false;
		}
		return true; 
	}

	public Supplier getSupplierBySupplierId(int supplierId) {
		Supplier supplier=(Supplier) sessionfactory.getCurrentSession().get(Supplier.class, supplierId);
		return supplier;
	}
	

	public boolean deleteSupplier(Supplier supplier) {
		try {
			supplier=sessionfactory.getCurrentSession().load(Supplier.class, supplier.getSupplierID());
			sessionfactory.getCurrentSession().delete(supplier);
		} catch (HibernateException e) {
			return false;
		}
		return true;
	}

	public List<Supplier> getAllSuppliers() {
		return sessionfactory.getCurrentSession().createQuery("from Supplier").list();
		
	}


	
	

}
