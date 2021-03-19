package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SaleOrder {

	private ArrayList<OrderLine> orderLines;
	private int orderNo;
	private Customer customer;
	private LocalDateTime date;
	private double amount;
	private String deliveryStatus;
	private LocalDateTime deliveryDate;
	private int invoiceNo;
	private LocalDateTime paymentDate;
		
	public SaleOrder(ArrayList<OrderLine> orderLines, int orderNo ,Customer customer,LocalDateTime date , double amount, String deliveryStatus, LocalDateTime deliveryDate, int invoiceNo, LocalDateTime paymentDate) {
		this.orderLines = new ArrayList<OrderLine>();
		this.orderLines = orderLines;
		this.orderNo = orderNo;
		this.customer = customer;
		this.date = date;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		
	}
	
	public SaleOrder(Customer customer) {
		this.orderLines = new ArrayList<OrderLine>();
		this.customer = customer;
	}
	
	public void addOrderLine(OrderLine orderLine) {
		this.orderLines.add(orderLine);
	}
	
	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}
	
	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines; 
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}
	
	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}


	

}