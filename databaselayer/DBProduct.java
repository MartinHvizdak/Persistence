package databaselayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Product;

public class DBProduct implements IDBProduct{
	
	public Product findProductByBarcode(int barcode)  throws DatabaseLayerException {
		Product product = null;
		Connection con = DBConnection.getInstance().getDBcon();

		String baseSelect = "select * from Product WHERE Barcode = " + barcode;
		
		System.out.println(baseSelect);
	
		
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
            ResultSet rs = stmt.executeQuery(baseSelect);
            
			rs.next();
			 
			
			product = new Product(rs.getString("Name"), rs.getDouble("PurchacePrice"), rs.getDouble("SalesPrice"), rs.getDouble("RentPrice"),  rs.getString("CountryOfOrigin"),rs.getInt("MinStock"),rs.getInt("CurrenyStock"));
			 
			 
			stmt.close();
		} catch (SQLException ex) {
			product = null;
			DatabaseLayerException dle = new DatabaseLayerException("Error retrieving data");
			dle.setStackTrace(ex.getStackTrace());
			ex.printStackTrace();
			throw dle;
		} catch (NullPointerException ex) {
			product = null;
			DatabaseLayerException dle = new DatabaseLayerException("Null pointer exception - possibly Connection object");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} catch (Exception ex) {
			product = null;
			DatabaseLayerException dle = new DatabaseLayerException("Data not retrieved! Technical error");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} finally {
			DBConnection.closeConnection();
		}
				
		return product;
		
	}
}
