/*package com.anshuman.books4ubackend;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anshuman.books4ubackend.Dao.SupplierDAO;

import com.anshuman.books4ubackend.model.Supplier;

public class SupplierJUnitTestTest {

	@Autowired
	static private AnnotationConfigApplicationContext context;
	// Autowired creates auto instance i.e for automatic creation
	@Autowired
	static private SupplierDAO supplierDAO;

	@Autowired
	static private Supplier supplier;

	// before class gets executed this method(under Before Class) gets execute
	@BeforeClass
	static public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.anshuman.books4ubackend");
		context.refresh();
		supplier = (Supplier) context.getBean("supplier");
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

	}

	@Ignore
	@Test
	public void testforsavingSupplier() {

		supplier.setCompanyName("M/s OM BOOK STORE");
		supplier.setCompanyAdress("C.P Block A 110001");
		supplier.setCompanyEmail("om.book@gmail.com");
		supplier.setContactInfo("011-22468948");
		supplier.setActive(true);
		assertTrue(supplierDAO.saveSupplier(supplier));
	}

	@Ignore
	@Test(expected = PersistenceException.class)
	public void testforsavingSupplierFailure() {
		supplier.setCompanyName("M/s OM BOOK STORE");
		supplier.setCompanyAdress("C.P Block A 110001");
		supplier.setCompanyEmail("om.book@gmail.com");
		supplier.setContactInfo("011-22468948");
		supplier.setActive(true);
		assertTrue(supplierDAO.saveSupplier(supplier));
	}
	@Test
	public void testForUpdatingSupplierPass() {
		supplier = supplierDAO.getAllSuppliers().get(0);
		supplier.setActive(!supplier.isActive());
		assertTrue(supplierDAO.updateSupplier(supplier));
	}

	@Test(expected = PersistenceException.class)
	public void testForUpdatingSupplierFail() {
		supplier = supplierDAO.getAllSuppliers().get(0);
		supplier.setSupplierID(78);
		assertFalse(supplierDAO.updateSupplier(supplier));
	}

	@Test
	public void testForGetSupplierByIdPass() {
		List<Supplier> supplierList = supplierDAO.getAllSuppliers();
		supplierList.forEach((temp) -> {
			assertEquals(temp, supplierDAO.getSupplierBySupplierId(temp.getSupplierID()));
		});
	}

	@Test
	public void testForGetSupplierByIdFail() {
		List<Supplier> supplierList = supplierDAO.getAllSuppliers();
		supplierList.forEach((temp) -> {
			assertNotEquals(temp, supplierDAO.getSupplierBySupplierId(temp.getSupplierID() + 10));
		});
	}

	@Test
	public void testForGetAllSuppliers() {
		assertNotNull(supplierDAO.getAllSuppliers());
	}

	@Ignore
	@Test
	public void testForDeleteSupplierPass() {
		supplier = supplierDAO.getAllSuppliers().get(0);
		assertTrue(supplierDAO.deleteSupplier(supplier));
	}

	@Test(expected = EntityNotFoundException.class)
	public void testForDeleteSupplierFail() {
		supplier.setSupplierID(27667667);
		assertFalse(supplierDAO.deleteSupplier(supplier));
	}

}
*/