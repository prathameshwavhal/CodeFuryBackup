package com.oms.model;

import java.util.Date;
import java.util.List;

public class Invoice {
	private int invoiceId;
	private Date invoiceDate;
	private int orderId;
	private String customer;
	private Customer customerId;
	private List<Product> productList;
	private GSTType gstType;
	private double totalGSTAmount;
	private double totalInvoiceValue;
	private InvoiceStatus status;
	private double totalOrderValue;

	public enum GSTType {
		INTER_STATE, SAME_STATE
	}

	public enum InvoiceStatus {
		PAID, UNPAID
	}

	// Constructors
	public Invoice(int invoiceId, Date invoiceDate, int orderid, String customer, List<Product> productList,
			GSTType gstType, double totalGSTAmount, double totalInvoiceValue, InvoiceStatus status) {
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		this.orderId = orderid;
		this.customer = customer;
		this.productList = productList;
		this.gstType = gstType;
		this.totalGSTAmount = totalGSTAmount;
		this.totalInvoiceValue = totalInvoiceValue;
		this.status = status;
	}

	public Invoice() {
	}

	// Getters and setters
	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int order) {
		this.orderId = order;
	}

	public Customer getCustomerId() {
		return customerId;
	}
	
	public String getCustomer()
	{
		return customer;
	}
	public void setCustomer(String string) {
		this.customer = string;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> list) {
		this.productList = list;
	}

	public GSTType getGstType() {
		return gstType;
	}

	public void setGstType(GSTType gstType) {
		this.gstType = gstType;
	}

	public double getTotalGSTAmount() {
		return totalGSTAmount;
	}

	public void setTotalGSTAmount(double totalGSTAmount) {
		this.totalGSTAmount = totalGSTAmount;
	}

	public double getTotalInvoiceValue() {
		return totalInvoiceValue;
	}

	public void setTotalInvoiceValue(double totalInvoiceValue) {
		this.totalInvoiceValue = totalInvoiceValue;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Invoice{" + "invoiceId=" + invoiceId + ", invoiceDate=" + invoiceDate + ", order=" + orderId
				+ ", customer=" + customer + ", productList=" + productList + ", gstType=" + gstType
				+ ", totalGSTAmount=" + totalGSTAmount + ", totalInvoiceValue=" + totalInvoiceValue + ", status="
				+ status + '}';
	}

	// Calculate shipping cost based on order value and product levels
	public double calculateShippingCost() {
		double shippingCost = 0.0;

		// Check if the order value is less than 1,00,000
		if (totalOrderValue < 100000) {
			for (Product product : productList) {
				double productPrice = product.getPrice();
			
				switch (product.getCategory()) {
				case Level_1:
					shippingCost += (0.05 * productPrice); // 5% shipping cost for Level 1
					break;
				case Level_2:
					shippingCost += (0.03 * productPrice); // 3% shipping cost for Level 2
					break;
				case Level_3:
					shippingCost += (0.02 * productPrice); // 2% shipping cost for Level 3
					break;
				}
			}
		}

		return shippingCost;
	}

	// Calculate the total order value
	public double calculateTotalOrderValue() {
		double totalProductValue = 0.0;

		// Calculate the sum of product prices
		for (Product product : productList) {
			totalProductValue += product.getPrice();
		}

		// Calculate the total order value by adding product prices, shipping cost, and
		// GST
		totalOrderValue = totalProductValue + calculateShippingCost() + calculateGST();

		return totalOrderValue;
	}

	// Calculate GST based on the flat rate (10%)
	public double calculateGST() {
		return totalOrderValue * 0.10;
	}

}
