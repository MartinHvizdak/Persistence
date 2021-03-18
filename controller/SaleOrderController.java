package controller;

import model.SaleOrder;
import model.Customer;
import model.Product;
import model.OrderLine;
import model.OrderType;
import db.DBException;
import db.DBSaleOrder;

public class SaleOrderController {
	CustomerController customerController;
	ProductController productController;
	DBSaleOrder dbSaleOrder;

	public SaleOrderController() {
		customerController = new CustomerController();
		productController = new ProductController();
		dbSaleOrder =  new DBSaleOrder();
	}
	
	public SaleOrder createOrder(int customerNo) throws DBException {
		Customer c = customerController.findCustomerByNumber(customerNo);
		
		return new SaleOrder(c);
	}
	
	public String addProduct(SaleOrder order, int barcode, int quantity) throws DBException {
		Product p;
		int stock;
		OrderLine ol;
		p = productController.findProductByBarcode(barcode);
		stock = p.getCurrentStock();
		if(stock > 0) {
			ol = new OrderLine(p, quantity, OrderType.Type.SALE);
			order.addOrderLine(ol);
			return "Product added";
		}else
			return "Out of stock";

	}
	
	public void confirmOrder(SaleOrder order) throws DBException {
		dbSaleOrder.saveOrder(order);
	}
}
