package Model;

public class Clothing {
	private String type;
	private String size;
	private String colour;
	
	public Clothing(String type, String size, String colour) {
		this.type = type;
		this.size = size;
		this.colour = colour;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColour() {
		return colour; 
	}
	public void setColour(String colour) {
		this.colour = colour; 
	}

}
