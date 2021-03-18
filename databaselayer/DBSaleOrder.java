package databaselayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.SaleOrder;

public class DBSaleOrder {

	public void saveOrder(SaleOrder o, int customerId) throws DatabaseLayerException {
		
		
		int insertedKey = 1;

		Connection con = DBConnection.getInstance().getDBcon();

		String baseInsert = "insert into SaleOrder (OrderDate, Amount, DeliveryStatus, DeliveryDate, CustomerNo) values ";
		baseInsert += "(" + o.getDate() + ", " + o.getAmount() + ", " + o.getDeliveryStatus() + ", " + o.getDeliveryDate() + ", " + customerId + ")";
		System.out.println(baseInsert);

		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			stmt.executeUpdate(baseInsert, Statement.RETURN_GENERATED_KEYS);
	
			ResultSet rs = stmt.getGeneratedKeys();
		    if (rs.next()) {
		    	insertedKey = rs.getInt(1);
		    }
		    stmt.close();
		} catch (SQLException ex) {
			insertedKey = -1;
			DatabaseLayerException dle = new DatabaseLayerException("Error inserting data");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} catch (NullPointerException ex) {
			insertedKey = -2;
			DatabaseLayerException dle = new DatabaseLayerException("Null pointer exception - possibly Connection object");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} catch (Exception ex) {
			insertedKey = -3;
			DatabaseLayerException dle = new DatabaseLayerException("Data not inserted! Technical error");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} finally {
			DBConnection.closeConnection();
		}
		
		System.out.println("Inserted key: " + insertedKey);
		
		
		
	}
}
