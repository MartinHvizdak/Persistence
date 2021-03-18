package db;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBProduct implements IDBProduct{
	
	public Product findByBarcode(int barcode) throws DBException{
		Product product = new Product(barcode);
		Connection con = DBConnection.getInstance().getDBcon();

		String selectQuery = "select * from Product where Barcode="+barcode;
		System.out.println(selectQuery);
		
		try {
			Statement stmt = con.createStatement();
			
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery(selectQuery);
			rs.next();
			
			product.setName(rs.getString("Name"));
			product.setPurchasePrice(rs.getInt("PurchacePrice"));
			product.setSalesPrice(rs.getDouble("SaleSprice"));
			product.setRentPrice(rs.getDouble("RentPrice"));
			product.setCountryOfOrigin(rs.getString("CountryOfOrigin"));
			product.setMinStock(rs.getInt("MinStock"));
			product.setCurrentStock(rs.getInt("CurrenyStock"));
			stmt.close();
		} catch (SQLException ex) {
			product = null;
			DBException de = new DBException("Error retrieving data");
			de.setStackTrace(ex.getStackTrace());
			throw de;
		} catch (NullPointerException ex) {
			product = null;
			DBException de = new DBException("Null pointer exception - possibly Connection object");
			de.setStackTrace(ex.getStackTrace());
			throw de;
		} catch (Exception ex) {
			product = null;
			DBException de = new DBException("Data not retrieved! Technical error");
			de.setStackTrace(ex.getStackTrace());
			throw de;
		} finally {
			DBConnection.closeConnection();
		}
				
		return product;
	}
}
