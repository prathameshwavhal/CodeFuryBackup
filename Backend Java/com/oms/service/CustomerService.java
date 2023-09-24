package com.oms.service;

//for hashing
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import com.oms.exceptions.CustomerNotFoundException;
import com.oms.exceptions.InvalidPasswordException;
import com.oms.model.Customer;
import com.oms.model.Order;
import com.oms.model.Quote;
import com.oms.persistence.CustomerRepository;
import com.oms.persistence.OrderRepository;
import com.oms.persistence.QuoteRepository;

public class CustomerService {
	private static CustomerRepository customerRepository;
	private static QuoteRepository quoteRepository;
	private static OrderRepository orderRepository;

	public CustomerService() {
		this.customerRepository = new CustomerRepository();
		this.quoteRepository = new QuoteRepository();
		this.orderRepository = new OrderRepository();
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	public boolean login(int customerId, String password)
			throws InvalidPasswordException, CustomerNotFoundException, SQLException {
		Customer customer = customerRepository.findByCustomerId(customerId);
		if (customer != null) {
			// Verify the hashed password against the provided password
			String hashedPassword = hashPassword(password);
			
			
			if (customer.getHashedpassword().equals(hashedPassword)) {
				// Passwords match, customer is logged in
				return true;
			} else {
				throw new InvalidPasswordException("Invalid Credentials!");
			}
		} else {
			throw new CustomerNotFoundException("Customer not found!!");
		}
	}

	private String hashPassword(String password) {
		try {
			// Create a SHA-256 message digest instance
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			// Convert the password to bytes
			byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);

			// Hash the password bytes
			byte[] hashedBytes = digest.digest(passwordBytes);

			// Convert the hashed bytes to a Base64-encoded string
			return Base64.getEncoder().encodeToString(hashedBytes);
		} catch (NoSuchAlgorithmException e) {
			// Handle the exception (e.g., log or throw a custom exception)
			e.printStackTrace();
			return null;
		}
	}

	public static List<Quote> getAllQuotesByCustId(int customerId) {
		return quoteRepository.getAllQuotesByCustomerId(customerId);
	}

	public static List<Order> getAllOrdersByCustId(int customerId) {
		return orderRepository.getAllOrdersByCustomerId(customerId);
	}

	public static Customer findCustomerById(int customerId) throws CustomerNotFoundException{
		
		Customer customer =customerRepository.findByCustomerId(customerId);
		return customer;
	}

}
