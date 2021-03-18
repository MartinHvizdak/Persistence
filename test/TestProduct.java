package test;

import org.junit.*;

import static org.junit.Assert.*;

import controller.*;
import db.DBException;
import model.*;


public class TestProduct {
	
	// Credit in minutes before and after testing operation
	int quantity;
	int barcode;
	ProductController productController;
	Product product;
	
	@Before
	public void setUp() {
		productController = new ProductController();
		barcode = 100200;	// Cowboy Hat , 10 quantity

	}
	
	@Test
	public void isInStock() {
		
		//Both methods are ignoring the values as they should
		try {
			quantity = 5;
			product = productController.findProductByBarcode(barcode);

			System.out.println(product.getName());
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertTrue(product.getCurrentStock() - quantity > 0);

		
	}
	
	
	@Test
	public void isOutOfStock() {
		
		//Both methods are ignoring the values as they should
		try {
			quantity = 50;
			product = productController.findProductByBarcode(barcode);

			System.out.println(product.getName());
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertTrue(product.getCurrentStock() - quantity < 0);

		
	}
	
	@Test
	public void InvalidBarcode() {
		
		//Both methods are ignoring the values as they should
		try {
			barcode = 154751658; //INVALID BARCODE
			product = productController.findProductByBarcode(barcode);

		} catch (DBException e) {
			e.printStackTrace();
			assertEquals("Product does not exist / Error retrieving data", e.getLocalizedMessage());
		}
	}
	@Test
	public void ValidBarcode() {
		
		//Both methods are ignoring the values as they should
		try {
			barcode = 100200; //VALID BARCODE
			product = productController.findProductByBarcode(barcode);

		} catch (DBException e) {
			e.printStackTrace();
			
		}
		System.out.println(product.getName());
		assertNotNull(product);
		
	}
}
