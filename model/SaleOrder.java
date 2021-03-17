package Model;

import java.time.LocalDate;

public class SaleOrder {

	private OrderLine orderLine;
	private LocalDate date;
	private double amount;
	private String deliveryStatus;
	private LocalDate deliveryDate;
	private int invoiceNo;
	private LocalDate paymentDate;
		
	public SaleOrder(OrderLine orderLine, LocalDate date, double amount, String deliveryStatus, LocalDate deliveryDate, int invoiceNo, LocalDate paymentDate) {
		this.orderLine = orderLine;
		this.date = date;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		
	}
	public SaleOrder() {
	}
	
	public OrderLine getOrderLine() {
		return orderLine;
	}
	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine; 
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}


	

}