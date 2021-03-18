package controller;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.Assert.*;

import db.DBException;
import model.SaleOrder;
import db.DBConnection;

public class OrderProcessingTest {
	
	private SaleOrderController soc;
	private SaleOrder saleOrder;
	
	@Before
	public void setUp() {
		soc = new SaleOrderController();
	}
	
	@Test
	public void successfulOrder() throws DBException {
		saleOrder = soc.createOrder(101);
		
		String result = soc.addProduct(saleOrder, 100201, 0);
		assertEquals("Should return the same string", "Product added", result);
	}
}
