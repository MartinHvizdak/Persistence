package controller;

import model.Supplier;
import db.DBSupplier;

public class SupplierController {
	Supplier supplier;
	DBSupplier dbSupplier;
	public SupplierController() {}
	
	public void addSupplier(String name, String address, String zipcode,
			String city, String country, String phoneno, String email) {
		supplier = new Supplier(name, address, zipcode, city, 
				country, phoneno, email);
	}
	
	public Supplier showSupplier(String email) {
		supplier = dbSupplier.getSupplier(email);
		System.out.println("Supplier will be shown here after further updates");
		return supplier;
	}
	
	public Supplier getSupplierFromDB(String email) {
		supplier = dbSupplier.getSupplier(email);
		return supplier;
	}
	
	public Supplier deleteSupplierFromDB(String email) {
		supplier = dbSupplier.deleteSupplier(email);
		return supplier;
	}
	
	public Supplier updateSupplierFromDB(String email, String name, String address,
			String country, String phoneNo, String zipcode) {
		supplier = dbSupplier.updateSupplier(email, name, address,
				country, phoneNo, zipcode);
		return supplier;
		}
}
