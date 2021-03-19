package model;

public class OrderLine {
	Product product;
	private int quantity;
	private OrderType.Type orderType;
	
	public OrderLine(Product product, int quantity, OrderType.Type orderType) {
		this.product = product;
		this.quantity = quantity; 
		this.orderType = orderType;
	}
	
	public Product getProduct() {
		return product; 
	}
	
	public void setProduct(Product product) {
		this.product = product; 
	}
	
	public int getQuantity() {
		return quantity; 
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity; 
	}
	
	public OrderType.Type getOrderType() {
		return orderType;
	}
	
	public void setOrderType(OrderType.Type orderType) {
		this.orderType = orderType;
	}
}
