package com.ops.presentation;

import java.util.List;
import java.util.Scanner;

import com.oms.model.Customer;
import com.oms.model.Order;
import com.oms.model.Quote;
import com.oms.service.CustomerService;

public class CustomerOrderManagementScreen {

	public void displayQuotes(Customer current_customer) {
		List<Quote> quotes = CustomerService.getAllQuotesByCustId(current_customer.getCustomerId());
		System.out.println("List of Quotes (Pending for Approval):");
		// Loop through and display quotes
		for (Quote quote : quotes) {
			System.out.println("Quote ID: " + quote.getQuoteId());
			System.out.println("Order Date: " + quote.getOrderDate());
			System.out.println("Customer Name: " + quote.getCustomerName());
			System.out.println("Customer GST No: " + quote.getCustomerGSTNo());
			System.out.println("Shipping Address: " + quote.getShippingAddress());
			System.out.println("Customer City: " + quote.getCustomerCity());
			System.out.println("Phone Number: " + quote.getPhoneNumber());
			System.out.println("Email: " + quote.getEmail());
			System.out.println("Pin Code: " + quote.getPinCode());
			System.out.println("Shipping Cost: " + quote.getShippingCost());
			System.out.println("Total Order Value: " + quote.getTotalOrderValue());
			System.out.println("Status: " + quote.getStatus());
			System.out.println(); // Added a newline for separation
		}

	}

	public void displayOrders(Customer current_customer) {
		List<Order> ordersList = CustomerService.getAllOrdersByCustId(current_customer.getCustomerId());
		System.out.println("List of Orders :");
		// Loop through and display Orders
		for (Order order : ordersList) {
			System.out.println("Quote ID: " + order.getOrderId());
			System.out.println("Order Date: " + order.getOrderDate());
			System.out.println("Customer: " + order.getCustomerName());
			System.out.println("Customer Shipping Address: " + order.getCustomerShippingAddress());

			System.out.println("Total Order Value: " + order.getTotalOrderValue());
			System.out.println("Shipping Cost: " + order.getShippingCost());
			System.out.println("Shipping Agency: " + order.getShippingAgency());
			System.out.println("Order Status: " + order.getStatus());
			System.out.println("---------------------------------");
		}
	}

	public void showMenu() {
		// Display menu options
		
			System.out.println("1. Approve Quote");
			System.out.println("2. Show Invoice");
			System.out.println("3. Exit to Home");
		
	}

}
