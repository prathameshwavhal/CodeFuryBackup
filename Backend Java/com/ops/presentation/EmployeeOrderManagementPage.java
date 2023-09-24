package com.ops.presentation;

import java.util.List;
import java.util.Scanner;

import com.oms.model.Employee;
import com.oms.model.Order;
import com.oms.service.EmployeeService;

public class EmployeeOrderManagementPage {
	public void displayEmployeeInfo(Employee employee) {
		System.out.println("Employee Information:");
		System.out.println("Employee ID: " + employee.getEmpId());
		System.out.println("Last logged In: " + employee.getLastLogin());
		System.out.println("---------------------------------");
	}

	public void displayOrders() {
		List<Order> ordersList = EmployeeService.getAllOrders();
		System.out.println("List of Orders :");
		// Loop through and display Orders
		for (Order order : ordersList) {
			System.out.println("Quote ID: " + order.getOrderId());
			System.out.println("Order Date: " + order.getOrderDate());
			System.out.println("Customer: " + order.getCustomerName());
			System.out.println("Customer Shipping Address: " + order.getCustomerShippingAddress());

			System.out.println("Product List:" + order.getProductIds());

			System.out.println("Total Order Value: " + order.getTotalOrderValue());
			System.out.println("Shipping Cost: " + order.getShippingCost());
			System.out.println("Shipping Agency: " + order.getShippingAgency());
			System.out.println("Order Status: " + order.getStatus());
			System.out.println("---------------------------------");
		}
	}

	public void showMenu() {
		// Display menu options
		System.out.println("1. Create New Quote");
		System.out.println("2. Import Products");
		System.out.println("3. Exit to Home");

	
	}
}
