package com.ops.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import com.oms.exceptions.CustomerNotFoundException;
import com.oms.exceptions.EmployeeNotFoundException;
import com.oms.exceptions.InvalidPasswordException;
import com.oms.exceptions.OrderNotFoundException;
import com.oms.exceptions.ProductNotFoundException;
import com.oms.model.Customer;
import com.oms.model.Employee;
import com.oms.persistence.ProductRepository;
import com.oms.service.CustomerService;
import com.oms.service.EmployeeService;
import com.oms.service.QuoteService;

public class MainUI {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Create instances of screen classes
		HomeScreen homeScreen = new HomeScreen();

		while (true) {
			// Display the Home Page and options
			homeScreen.display();
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				// Employee Login Screen
				EmployeeLoginScreen loginScreen = new EmployeeLoginScreen();
				EmployeeService employeeService = new EmployeeService();

				String empId = loginScreen.getInputEmployeeId();
				String password = loginScreen.getInputPassword();

				try {
					try {
						if (employeeService.login(empId, password)) {
							Employee current_employee = employeeService.findEmployeeById(empId);
							System.out.println("Login successful!");
							EmployeeOrderManagementPage employeeOMPScreen = new EmployeeOrderManagementPage();

							// Employee Order Management Page
							employeeOMPScreen.displayEmployeeInfo(current_employee);
							employeeOMPScreen.displayOrders();
							boolean logout=true;
							
							while(logout)
								{
								employeeOMPScreen.showMenu();
								int empChoice;
								empChoice = scanner.nextInt();
								switch (empChoice) {
								case 1:
									// Create new Quote feature
									
									QuoteService quoteService = new QuoteService();
									CreateQuoteScreen createQScreen = new CreateQuoteScreen(quoteService);
	
									try {
										createQScreen.captureUserInputAndCreateQuote();
									} catch (CustomerNotFoundException e) {
										System.out.println(e.getMessage());
									
									
									}
									break;
									
								case 2:
									// Import Products Feature
							
									ImportProductsScreen importProductsScreen = new ImportProductsScreen(
											new ProductRepository());
						
									try
									{
										importProductsScreen.importProducts();
									}
									catch(Exception e)
									{
										System.out.println(e.getMessage());
									}
									break;
								case 3:
									logout=false;
									System.out.println("Logged Out Successfully!");
									break;
								default:
									System.out.println("Invalid Choice!!");
								}

							} 
						}
						else {
							System.out.println("Login failed. Please check your credentials.");
						}
					} 
					catch (EmployeeNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
				} catch (InvalidPasswordException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				// Customer Login
				CustomerLoginScreen loginScreen2 = new CustomerLoginScreen();
				CustomerService customerService = new CustomerService();

				int customerId = loginScreen2.getInputCustomerId();
				String c_password = loginScreen2.getInputPassword();

				try {
					if (customerService.login(customerId, c_password)) {
						Customer current_customer = customerService.findCustomerById(customerId);
						System.out.println("Login successful!");
						CustomerOrderManagementScreen custOMPScreen = new CustomerOrderManagementScreen();
						// Customer Order Management Page
						custOMPScreen.displayQuotes(current_customer);
						custOMPScreen.displayOrders(current_customer);
						boolean logout=true;
						while(logout)
						{
						custOMPScreen.showMenu();
						
							int custChoice= new Scanner(System.in).nextInt();
							System.out.println(custChoice);
							switch (custChoice) 
							{
							case 1:
								// Approve Quote
								System.out.print("Enter the Quote ID to approve: ");
								int quoteIdToApprove = new Scanner(System.in).nextInt();
								QuoteService quoteService = new QuoteService();
								// Attempt to approve the quote
								boolean isApproved = quoteService.approveQuote(quoteIdToApprove);
	
								// Inform the user about the approval status
								if (isApproved) {
									System.out.println("Quote approved successfully!");
								} else {
									System.out.println("Quote approval failed or expired.");
								}
	
								break;
							case 2:
	
								// Invoice generation feature
								System.out.print("Enter the Order ID for the invoice: ");
								int orderIdForInvoice = scanner.nextInt();
	
								InvoiceScreen invoiceScreen = new InvoiceScreen();
								
								try
								{
									invoiceScreen.displayInvoice(orderIdForInvoice);
								}
								catch(ProductNotFoundException | OrderNotFoundException e)
								{
									System.out.println(e.getMessage());
								}
								
	
								break;
							case 3:
								logout=false;
								System.out.println("Logged Out Successfully!");
								break;
							default:
								System.out.println("Invalid Choice!!");
							}
						}
					} else {
						System.out.println("Login failed. Please check your credentials.");
					}
				} catch (CustomerNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (InvalidPasswordException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				// Exit the application
				System.out.println("Exiting the application.");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}
}
