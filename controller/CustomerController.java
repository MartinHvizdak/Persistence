package controller;

import model.Customer;
import db.DBCustomer;
import db.DBException;

public class CustomerController {
	DBCustomer dbCustomer;
	public CustomerController() {
		dbCustomer = new DBCustomer();
	}
	
	public Customer findCustomerByNumber(int customerNo) throws DBException {
		return dbCustomer.findCustomerByNumber(customerNo);
	}
}
