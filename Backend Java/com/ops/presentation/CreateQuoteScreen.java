package com.ops.presentation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.oms.exceptions.CustomerNotFoundException;
import com.oms.model.Customer;
import com.oms.model.Quote;
import com.oms.service.CustomerService;
import com.oms.service.QuoteService;

public class CreateQuoteScreen {
	private QuoteService quoteService = new QuoteService();
	private static CustomerService customerService = new CustomerService();
	
	public CreateQuoteScreen(QuoteService quoteService) {
		this.quoteService = quoteService;
	}

	public void captureUserInputAndCreateQuote() throws CustomerNotFoundException {
		Scanner scanner = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		// Capture user input for quote details
		System.out.print("Enter Order Date (yyyy-MM-dd): ");
		String orderDateStr = scanner.nextLine();
		Date orderDate = parseDate(orderDateStr);

		System.out.print("Enter Customer ID: ");
		int customerId = scanner.nextInt();

		System.out.print("Enter Shipping Cost: ");
		double shippingCost = scanner.nextDouble();

		System.out.print("Enter Total Order Value: ");
		double totalOrderValue = scanner.nextDouble();

		// Check if the customer exists
		boolean customerExists = QuoteService.checkCustomerExists(customerId);
		System.out.println(customerExists);
		if (customerExists) {
			// If customer exists, auto-populating customer details
			Customer current_customer = customerService.findCustomerById(customerId);
			System.out.println(current_customer);
			String customerName = current_customer.getName();
			String gstNumber = current_customer.getGstNumber();
			String address = current_customer.getAddress();
			String city = current_customer.getCity();
			String email = current_customer.getEmail();
			String phone = current_customer.getPhone();
			String pinCode = current_customer.getPinCode();

			// Create a new quote with auto-populated customer details
			Quote quote = new Quote(customerId, orderDate, customerName, gstNumber, address, city, phone, email,
					pinCode, shippingCost, totalOrderValue, "pending");
			quoteService.updateQuote(quote);

			System.out.println("Quote Updated For Existing Customer successfully!");
		} 
		else {
			System.out.println("Customer not found. Please enter customer details manually.");
			System.out.print("Enter Customer Name/ID: ");
			String customerName = sc2.nextLine();

			System.out.print("Enter Customer GST No: ");
			String gstNumber = sc2.nextLine();

			System.out.print("Enter Customer Shipping Address: ");
			String shippingAddress = sc2.nextLine();

			System.out.print("Enter Customer City: ");
			String city = sc2.nextLine();

			System.out.print("Enter Customer Phone Number: ");
			String phone = sc2.nextLine();

			System.out.print("Enter Customer Email: ");
			String email = sc2.nextLine();

			System.out.print("Enter Customer Pin Code: ");
			String pinCode = sc2.nextLine();

			// Create a new quote with manually entered customer details
			Quote quote = new Quote(customerId, orderDate, customerName, gstNumber, shippingAddress, city, phone, email,
					pinCode, shippingCost, totalOrderValue, "pending");
			quoteService.createNewQuote(quote);

			System.out.println("Quote created successfully!");
		}
	}

	private Date parseDate(String dateStr) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
