package db;

import java.sql.SQLException;

import model.Supplier;

public class DBSupplier implements DBSupplierIF{

	@Override
	public Supplier insert(Supplier supplier) throws SQLException {
		String sql = String.format("insert into Supplier values ('%s', '%s', '%s', '%s', '%s', '%s')",
				supplier.getEmail(), supplier.getName(), supplier.getAddress(), supplier.getCountry(),
				supplier.getPhoneno(), supplier.getZipcode());
		// The connection to the database will be added when DBConnection will be added
		return supplier;
	}
	
	public Supplier getSupplier(String email) {
		// There will be a pull request from a database after DBConnection is made
		return null;
	}
	
	public Supplier deleteSupplier(String email) {
		// There will be an update request for a database
		return null;
	}
	
	public Supplier updateSupplier(String email, String name, String address,
			String country, String phoneNo, String zipcode) {
		//There will be a delete request for a database
		return null;		
	}
}
