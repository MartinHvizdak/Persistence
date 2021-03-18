package db;

import model.Product;

public interface IDBProduct {
	public Product findByBarcode(int barcode) throws DBException;
}
