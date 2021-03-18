package controller;

import model.Product;
import db.DBProduct;

public class ProductController {
	DBProduct dbProduct;
	public ProductController() {
		dbProduct = new DBProduct();
	}
	
	public Product findProductByBarcode(int barcode) {
		
		// needs checks to be added after the rest of the classes will be made
		return dbProduct.findProductByBarcode(barcode);
	}
}
