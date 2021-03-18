package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import model.Customer;

public class DBCustomer implements IDBCustomer {

	public Customer findCustomerByNumber(int customerNumber)  throws DBException {
		Customer customer = null;
		Connection con = DBConnection.getInstance().getDBcon();
		
		String select1 = "select Fname, Lname, Address, Zipcode, PhoneNo, CountryCode from Customer WHERE CustomerNo = ?";
		String select2 = "select City from ZipcodeCity WHERE Zipcode = ?";
		System.out.println(select1);
		System.out.println(select2);
		
		try {
			PreparedStatement stmt = con.prepareStatement(select1);
			String zipcode;
			customer = new Customer();
			
			stmt.setInt(1, customerNumber);
			stmt.setQueryTimeout(5);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			customer.setName(rs.getString("Fname")+" "+rs.getString("Lname"));
			customer.setAddress(rs.getString("Address"));
			customer.setZipcode(rs.getString("Zipcode"));
			customer.setPhoneNo(rs.getString("PhoneNo"));
			customer.setCountryCode(rs.getInt("CountryCode"));
			zipcode = rs.getString("Zipcode");
			
			stmt = con.prepareStatement(select2);
			stmt.setString(1, zipcode);
			stmt.setQueryTimeout(5);
			rs = stmt.executeQuery();
			rs.next();
			customer.setCity(rs.getString("City"));
			
			stmt.close();
		} catch (SQLException ex) {
			customer = null;
			DBException de = new DBException("Error retrieving data");
			de.setStackTrace(ex.getStackTrace());
			ex.printStackTrace();
			throw de;
		} catch (NullPointerException ex) {
			customer = null;
			DBException de = new DBException("Null pointer exception - possibly Connection object");
			de.setStackTrace(ex.getStackTrace());
			ex.printStackTrace();
			throw de;
		} catch (Exception ex) {
			customer = null;
			DBException de = new DBException("Data not retrieved! Technical error");
			de.setStackTrace(ex.getStackTrace());
			ex.printStackTrace();
			throw de;
		} finally {
			DBConnection.closeConnection();
		}
				
		return customer;
		
	}
}
