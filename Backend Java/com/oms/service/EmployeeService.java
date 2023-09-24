package com.oms.service;

import java.sql.SQLException;
import java.util.List;

import com.oms.exceptions.EmployeeNotFoundException;
import com.oms.exceptions.InvalidPasswordException;
import com.oms.model.Employee;
import com.oms.model.Order;
import com.oms.persistence.EmployeeRepository;
import com.oms.persistence.OrderRepository;

public class EmployeeService {

	private EmployeeRepository employeeRepository;
	private static OrderRepository orderRepository;

	public EmployeeService() {
		this.employeeRepository = new EmployeeRepository();
		this.orderRepository = new OrderRepository();
	}

	public boolean login(String empId, String password) throws InvalidPasswordException, EmployeeNotFoundException {
		try {
			boolean isValidCredentials = employeeRepository.validateCredentials(empId, password);
			if (isValidCredentials) {
				// Update the login status to true
				employeeRepository.updateLoginStatus(empId, true);
				return true; // Login successful
			} else {
				throw new InvalidPasswordException("Incorrect password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // Login failed
	}

	public Employee findEmployeeById(String empId) throws EmployeeNotFoundException {
		Employee emp = employeeRepository.findByEmployeeId(empId);
		return emp;
	}

	public static List<Order> getAllOrders() {
		List<Order> ordersList = orderRepository.getAllOrders();
		return ordersList;
	}

}
