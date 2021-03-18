package model;

public class OrderLine {
	Product product;
	private int amount;
	private OrderType.Type orderType;
	
	public OrderLine(Product product, int amount, OrderType.Type orderType) {
		this.product = product;
		this.amount = amount; 
		this.orderType = orderType;
	}
	
	public Product getProduct() {
		return product; 
	}
	
	public void setProduct(Product product) {
		this.product = product; 
	}
	
	public int getAmount() {
		return amount; 
	}
	
	public void setAmount(int amount) {
		this.amount = amount; 
	}
	
	public OrderType.Type getOrderType() {
		return orderType;
	}
	
	public void setOrderType(OrderType.Type orderType) {
		this.orderType = orderType;
	}
}
