package com.oms.model;

import java.util.Date;

public class Order {
	private int orderId;
	private Date orderDate;
	private String customerName;
	private String customerShippingAddress;
	private String productIds;
	private double totalOrderValue;
	private double shippingCost;
	private String shippingAgency;
	private OrderStatus status;
	private Invoice invoice;

	public enum OrderStatus {
		PENDING, APPROVED, COMPLETE, EXPIRED, INVOICED
	}

	// Constructors
	public Order(int orderId, Date orderDate, String customerName, String customerShippingAddress, 
			String productIds,double totalOrderValue, double shippingCost, String shippingAgency, OrderStatus status) {
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.customerName = customerName;
		this.customerShippingAddress = customerShippingAddress;
		this.productIds = productIds;
		this.totalOrderValue = totalOrderValue;
		this.shippingCost = shippingCost;
		this.shippingAgency = shippingAgency;
		this.status = status;
	}

	public Order() {
	}

	// Getters and setters
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public String getCustomerShippingAddress() {
		return customerShippingAddress;
	}

	public void setCustomerShippingAddress(String customerShippingAddress) {
		this.customerShippingAddress = customerShippingAddress;
	}

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public double getTotalOrderValue() {
		return totalOrderValue;
	}

	public void setTotalOrderValue(double totalOrderValue) {
		this.totalOrderValue = totalOrderValue;
	}

	public double getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}

	public String getShippingAgency() {
		return shippingAgency;
	}

	public void setShippingAgency(String shippingAgency) {
		this.shippingAgency = shippingAgency;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerShippingAddress == null) ? 0 : customerShippingAddress.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderId;
		result = prime * result + ((shippingAgency == null) ? 0 : shippingAgency.hashCode());
		long temp;
		temp = Double.doubleToLongBits(shippingCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		temp = Double.doubleToLongBits(totalOrderValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerShippingAddress == null) {
			if (other.customerShippingAddress != null)
				return false;
		} else if (!customerShippingAddress.equals(other.customerShippingAddress))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId != other.orderId)
			return false;
		if (shippingAgency == null) {
			if (other.shippingAgency != null)
				return false;
		} else if (!shippingAgency.equals(other.shippingAgency))
			return false;
		if (Double.doubleToLongBits(shippingCost) != Double.doubleToLongBits(other.shippingCost))
			return false;
		if (status != other.status)
			return false;
		if (Double.doubleToLongBits(totalOrderValue) != Double.doubleToLongBits(other.totalOrderValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order{" + "orderId=" + orderId + ", orderDate=" + orderDate + ", customeName=" + customerName
				+ ", customerShippingAddress='" + customerShippingAddress + '\'' + ", productList=" + productIds
				+ ", totalOrderValue=" + totalOrderValue + ", shippingCost=" + shippingCost + ", shippingAgency='"
				+ shippingAgency + '\'' + ", status=" + status + '}';
	}
}
