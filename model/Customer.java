package model;

public class Customer {
	private int customerNo;
	private String name;
	private String address;
	private String zipcode;
	private String city;
	private String phoneNo;
	private int countryCode;


	public Customer(int customerNo, String name, String address, String zipcode, String city, String phoneNo, int countryCode) {
		this.name = name;
		this.address = address; 
		this.zipcode = zipcode;
		this.city = city;
		this.phoneNo= phoneNo;
		this.countryCode = countryCode;
		
	}
	
	public Customer() {
		
	}
	
	public int getCustomerNo() {
		return customerNo;
	}
	
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
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
	
	public int getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

}