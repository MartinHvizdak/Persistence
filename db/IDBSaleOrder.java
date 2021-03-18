package db;

import model.OrderLine;
import model.SaleOrder;

public interface IDBSaleOrder {


	    // insert new OrderLine
	 	public void addOrderLine(OrderLine o) throws DBException;
	 		
	 	// Save Order
	 	public void saveOrder(SaleOrder o, int customerId) throws DBException;
	    
	
}
