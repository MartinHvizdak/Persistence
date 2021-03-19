package tests;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import controller.SaleOrderController;
import db.DBException;
import model.SaleOrder;

public class OrderProcessingTest {
	
	private SaleOrderController soc;
	private SaleOrder saleOrder;
	
	@Before
	public void setUp() {
		soc = new SaleOrderController();
	}
	
	@Test
	public void successfulOrder() {
		try {
			saleOrder = soc.createOrder(101);
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		String result = "";
		try {
			result = soc.addProduct(saleOrder, 100201, 0);
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertEquals("Should return the same string", "Product added", result);
	}
}