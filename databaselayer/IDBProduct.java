package databaselayer;
import model.Product;

public interface IDBProduct {
	// insert new OrderLine
		 	public Product findProductByBarcode(int barcode) throws DatabaseLayerException;
}
