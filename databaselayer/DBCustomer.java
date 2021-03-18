package databaselayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Customer;

public class DBCustomer implements IDBCustomer {

	public Customer findCustomerByNumber(int customerNumber)  throws DatabaseLayerException {
		Customer customer = null;
		Connection con = DBConnection.getInstance().getDBcon();

		 
	 	
		String baseSelect = "select * from Customer WHERE CustomerNo = " + customerNumber;
		
	
		
		System.out.println(baseSelect);

		
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
            ResultSet rs = stmt.executeQuery(baseSelect);
            
			 rs.next();
			 System.out.println("testik");
			
			 
			 customer = new Customer(rs.getString("Fname")+" "+rs.getString("Lname"), rs.getString("Address"), rs.getString("Zipcode"),  rs.getString("City"),rs.getString("PhoneNo"));
			 
			 
			stmt.close();
		} catch (SQLException ex) {
			customer = null;
			DatabaseLayerException dle = new DatabaseLayerException("Error retrieving data");
			dle.setStackTrace(ex.getStackTrace());
			ex.printStackTrace();
			throw dle;
		} catch (NullPointerException ex) {
			customer = null;
			DatabaseLayerException dle = new DatabaseLayerException("Null pointer exception - possibly Connection object");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} catch (Exception ex) {
			customer = null;
			DatabaseLayerException dle = new DatabaseLayerException("Data not retrieved! Technical error");
			dle.setStackTrace(ex.getStackTrace());
			throw dle;
		} finally {
			DBConnection.closeConnection();
		}
				
		return customer;
		
	}
}
