package controller;

import model.Product;
import db.DBException;
import db.DBProduct;

public class ProductController {
	DBProduct dbProduct;
		
	public ProductController() {
		dbProduct = new DBProduct();
	}
	
	public Product findProductByBarcode(int barcode) throws DBException {
		return dbProduct.findByBarcode(barcode);
	}

}
