package model;

public class GunReplica extends Product{
	private double calibre;
	private String material;
	
	public GunReplica(double calibre, String material, int barcode) { 
		super(barcode);
		this.calibre = calibre;
		this.material = material;
	}
	
	public GunReplica(int barcode) {
		super(barcode);
	}
	
	public double getCalibre() {
		return calibre;
	}
	
	public void setCalibre(double calibre) {
		this.calibre = calibre; 
	}
	public String getMaterial() {
		return material; 
	}
	public void setMaterial(String material) {
		this.material = material; 
	}

}
