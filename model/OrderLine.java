package Model;

public class OrderLine {
	
	private double amount;
	private String orderType;
	
	public OrderLine(double amount, String orderType) {
		this.amount = amount; 
		this.orderType = orderType;
	}
	public double getAmount() {
		return amount; 
	}
	public void setAmount(double amount) {
		this.amount = amount; 
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
}
