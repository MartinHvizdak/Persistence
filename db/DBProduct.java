package db;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBProduct implements IDBProduct{
	
	
	
	public Product findByBarcode(int barcode) throws DBException{
		Product product = new Product(barcode);
		Connection con = DBConnection.getInstance().getDBcon();

		String select = "select Barcode, Name, PurchacePrice, SaleSprice, RentPrice, CountryOfOrigin, MinStock, CurrentStock, ProductType from Product where Barcode=?";
		System.out.println(select);
		
		try {
			PreparedStatement stmt = con.prepareStatement(select);
			stmt.setInt(1, barcode);
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			product.setName(rs.getString("Name"));
			product.setPurchasePrice(rs.getInt("PurchacePrice"));
			product.setSalesPrice(rs.getInt("SaleSprice"));
			product.setRentPrice(rs.getInt("RentPrice"));
			product.setCountryOfOrigin(rs.getString("CountryOfOrigin"));
			product.setMinStock(rs.getInt("MinStock"));
			product.setCurrentStock(rs.getInt("CurrentStock"));
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
