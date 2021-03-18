package model;

public class Equipment extends Product{
	private String type;
	private String description;

	public Equipment(String type, String description, int barcode) {
		super(barcode);
		this.type = type;
		this.description = description;
	}
	
	public Equipment(int barcode) {
		super(barcode);
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}	
}
