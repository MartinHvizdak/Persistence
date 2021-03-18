package databaselayer;

import model.OrderLine;
import model.SaleOrder;

public interface IDBSaleOrder {


	    // insert new OrderLine
	 	public void addOrderLine(OrderLine o) throws DatabaseLayerException;
	 		
	 	// Save Order
	 	public void saveOrder(SaleOrder o, int customerId) throws DatabaseLayerException;
	    
	
}
