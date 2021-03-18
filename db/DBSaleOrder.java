package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.SaleOrder;

public class DBSaleOrder {

	public void saveOrder(SaleOrder o) throws DBException {
		
		Connection con = DBConnection.getInstance().getDBcon();

		String insert1 = "insert into SaleOrder (OrderNo, OrderDate, Amount, DeliveryStatus, DeliveryDate, CustomerNo) values (?, ?, ?, ?, ?, ?);";
		String insert2 = "insert into OrderLine (OrderNo, ProductBarcode, Quantity, OrderType) values (?, ?, ?)";
		String insert3 = "insert into Invoice (InvoiceNo, PaymentDate, SaleOrderNo) values (?, ?, ?)";
		System.out.println(insert1);
		System.out.println(insert2);
		System.out.println(insert3);

		try {
			PreparedStatement stmt = con.prepareStatement(insert1);
			
			stmt.setInt(1, o.getOrderNo());
			stmt.setTimestamp(2, Timestamp.valueOf(o.getDate()));
			stmt.setDouble(3, o.getAmount());
			stmt.setString(4, o.getDeliveryStatus());
			stmt.setTimestamp(5, Timestamp.valueOf(o.getDeliveryDate()));
			stmt.setInt(6, o.getCustomer().getCustomerNo());
			stmt.setQueryTimeout(5);
			stmt.execute();
			
			for(int i = 0; i < o.getOrderLines().size(); i++) {
				stmt = con.prepareStatement(insert2);
				stmt.setInt(1, o.getOrderNo());
				stmt.setInt(2, o.getOrderLines().get(i).getProduct().getBarcode());
				stmt.setInt(3, o.getOrderLines().get(i).getAmount());
				stmt.setString(4, o.getOrderLines().get(i).getOrderType().toString());
				stmt.setQueryTimeout(5);
				stmt.execute();
			}
			
			stmt = con.prepareStatement(insert3);
			stmt.setInt(1, o.getInvoiceNo());
			stmt.setTimestamp(2, Timestamp.valueOf(o.getPaymentDate()));
			stmt.setInt(3, o.getOrderNo());
			stmt.setQueryTimeout(5);
			stmt.execute();
			
		    stmt.close();
		} catch (SQLException ex) {
			DBException de = new DBException("Error inserting data");
			de.setStackTrace(ex.getStackTrace());
			ex.printStackTrace();
			throw de;
		} catch (NullPointerException ex) {
			DBException de = new DBException("Null pointer exception - possibly Connection object");
			de.setStackTrace(ex.getStackTrace());
			ex.printStackTrace();
			throw de;
		} catch (Exception ex) {
			DBException de = new DBException("Data not inserted! Technical error");
			de.setStackTrace(ex.getStackTrace());
			ex.printStackTrace();
			throw de;
		} finally {
			DBConnection.closeConnection();
		}
		
	}
}
