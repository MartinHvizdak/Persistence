package Model;

public class Customer {
	private String name;
	private String address;
	private String zipcode;
	private String city;
	private String phoneNo;


public Customer(String name, String address, String zipcode, String city, String phoneNo) {
	this.name = name;
	this.address = address; 
	this.zipcode = zipcode;
	this.city = city;
	this.phoneNo= phoneNo;
	
}
public Customer() {
	
}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}