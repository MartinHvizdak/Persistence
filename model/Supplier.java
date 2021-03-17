package model;


public class Supplier {
	private String name;
	private String address;
	private String zipcode;
	private String city;
	private String country;
	private String phoneno;
	private String email;
	
	public Supplier(String name, String address, String zipcode, String city, String country, String phoneno, String email){
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.country = country;
		this.phoneno = phoneno;
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;		
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public String getCity() {
		return city;
	}
	public String getCountry(){
		return country;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public String getEmail() {
		return email;
	}

}