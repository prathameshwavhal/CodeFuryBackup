package com.oms.model;

import java.util.Date;

public class Quote {
	private int quoteId;
	private Date orderDate;
	private String customerName;
	private String customerGSTNo;
	private String shippingAddress;
	private String customerCity;
	private String phoneNumber;
	private String email;
	private String pinCode;
	private double shippingCost;
	private double totalOrderValue;
	private String status;

	// Constructors, getters, and setters
	public Quote(int quoteId, Date orderDate, String customerName, String customerGSTNo, String shippingAddress,
			String customerCity, String phoneNumber, String email, String pinCode, double shippingCost,
			double totalOrderValue, String status) {
		super();
		this.quoteId = quoteId;
		this.orderDate = orderDate;
		this.customerName = customerName;
		this.customerGSTNo = customerGSTNo;
		this.shippingAddress = shippingAddress;
		this.customerCity = customerCity;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.pinCode = pinCode;
		this.shippingCost = shippingCost;
		this.totalOrderValue = totalOrderValue;
		this.status = status;
	}

	public int getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGSTNo() {
		return customerGSTNo;
	}

	public void setCustomerGSTNo(String customerGSTNo) {
		this.customerGSTNo = customerGSTNo;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public double getTotalOrderValue() {
		return totalOrderValue;
	}

	public void setTotalOrderValue(double totalOrderValue) {
		this.totalOrderValue = totalOrderValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Quote [quoteId=" + quoteId + ", orderDate=" + orderDate + ", customerName=" + customerName
				+ ", customerGSTNo=" + customerGSTNo + ", shippingAddress=" + shippingAddress + ", customerCity="
				+ customerCity + ", phoneNumber=" + phoneNumber + ", email=" + email + ", pinCode=" + pinCode
				+ ", shippingCost=" + shippingCost + ", totalOrderValue=" + totalOrderValue + ", status=" + status
				+ "]";
	}

}
