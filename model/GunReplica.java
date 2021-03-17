package Model;

public class GunReplica {
	private double calibre;
	private String material;
	
	public GunReplica(double calibre, String material) { 
		this.calibre = calibre;
		this.material = material;
		
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
