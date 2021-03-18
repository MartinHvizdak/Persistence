package controller;

import model.Customer;
import db.DBCustomer;

public class CustomerController {
	DBCustomer dbCustomer;
	public CustomerController() {
		dbCustomer = new DBCustomer();
	}
	
	public Customer finCustomerByCustomerNo(int customerNo) {
		// potentially, there will be a need to check if customer exists
		
		return dbCustomer.findCustomerByNumber(customerNo);
	}
}
