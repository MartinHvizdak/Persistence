package ui;
import java.util.Scanner;

import controller.SaleOrderController;
import db.DBException;
import model.SaleOrder;

public class SaleOrderMenu {
	SaleOrder order;

	SaleOrderController saleOrderController;
	
	public SaleOrderMenu() {
		saleOrderController = new SaleOrderController();
	}

    public void createOrder() {
    	int customerNo;
    	Scanner scanner = new Scanner(System.in);
    	
    	
    	System.out.println("Enter customer number:");
    	customerNo = scanner.nextInt();
    	try {
			order = saleOrderController.createOrder(customerNo);
			System.out.println("Order has been created and got a number:" + order.getOrderNo());
		} catch (DBException e) {
			System.out.println("There was a problem with retrieving customer data from DB.");
			System.out.println("Order was not created.");
			e.printStackTrace();
			order = null;
		}
    	scanner.close();
    }
    
    public void addProduct() {
    	int barcode;
    	int quantity;
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Enter product barcode:");
    	barcode = scanner.nextInt();
    	System.out.println("Enter product quantity:");
    	quantity = scanner.nextInt();
    	
    	String response;
		try {
			response = saleOrderController.addProduct(order, barcode, quantity);
			System.out.println(response);
		} catch (DBException e) {
			System.out.println("There was a problem with retrieving product data from DB.");
			System.out.println("Product was not added.");
			e.printStackTrace();
		}
    	
    	
    	scanner.close();
    }
    
    public void confirmOrder() {
    	try {
			saleOrderController.confirmOrder(order);
			System.out.println("Order confirmed");
			order = null;
		} catch (DBException e) {
			System.out.println("There was a problem with saving order in DB.");
			System.out.println("Order was not saved.");
			e.printStackTrace();
		}
    	
    }
}
