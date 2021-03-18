package db;

import model.Customer;

public interface IDBCustomer {

	// find Customer
		 	public Customer findCustomerByNumber(int customerNumber) throws DBException;
		 	
}
