package com.oms.model;

public class CompanySeller {
	private String companyName;
	private String address;
	private String city;
	private String gstNumber;

	// Constructors
	public CompanySeller(String companyName, String address, String city, String gstNumber) {
		this.companyName = companyName;
		this.address = address;
		this.city = city;
		this.gstNumber = gstNumber;
	}

	// Getters and setters
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	@Override
	public String toString() {
		return "CompanySeller{" + "companyName='" + companyName + '\'' + ", address='" + address + '\'' + ", city='"
				+ city + '\'' + ", gstNumber='" + gstNumber + '\'' + '}';
	}
}
