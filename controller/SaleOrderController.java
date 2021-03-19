package controller;

import java.time.LocalDateTime;

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
		LocalDateTime date = LocalDateTime.now();
		int orderNo = date.getMinute()%10 + date.getDayOfYear()%10 +  + date.getNano()%10 + date.getHour()%10;
		int invoiceNo = orderNo;
		String deliveryStatus = "waiting for payment";
		
		SaleOrder order = new SaleOrder(c);
		
		order.setDate(date);
		order.setOrderNo(orderNo);
		order.setInvoiceNo(invoiceNo);
		order.setDeliveryStatus(deliveryStatus);
		
		return order;
	}
	
	public String addProduct(SaleOrder order, int barcode, int quantity) throws DBException {
		Product p;
		int stock = 0;
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
	
	public void confirmOrder(SaleOrder o) throws DBException {
		int amount = 0;
		for(int i = 0; i < o.getOrderLines().size(); i++) {
			amount += o.getOrderLines().get(i).getProduct().getSalesPrice();
		}
		o.setAmount(amount);
		dbSaleOrder.saveOrder(o);
	}
}
