package model;

public class Product {
	private int barcode;
	private String name;
	private double purchasePrice;
	private double salesPrice;
	private double rentPrice;
	private String countryOfOrigin;
	private int minStock;
	private int currentStock;
	
	public Product(String name, double purchasePrice, double salesPrice, double rentPrice, String countryOfOrigin, int minStock, int currentStock, int barcode) {
		this.name = name; 
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minStock = minStock;
		this.currentStock = currentStock; 
		this.barcode = barcode;
	}
	
	public Product(int barcode) {
		this.barcode = barcode;
	}
	
	public int getBarcode() {
		return barcode;
	}
	
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	
	public String getName() {
			return name;
	}
	
	public void setName(String name) {
			this.name = name;
	}
		
	public double getPurchasePrice(){
			return purchasePrice;
	}
	
	public void setPurchasePrice(double purchasePrice) {
			this.purchasePrice = purchasePrice;
	}
		
	public double getSalesPrice() {
			return salesPrice;
	}
	
	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}
	
	public double getRentPrice() {
		return rentPrice;
	}
	
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice; 
	}
		
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
		
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	
	public int getMinStock() {
		return minStock;
	}
	
	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	
	public int getCurrentStock() {
		return currentStock;
	}
	
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}

}