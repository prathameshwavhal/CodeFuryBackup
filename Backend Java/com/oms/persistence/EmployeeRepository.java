package com.oms.persistence;

//For hashing
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.oms.exceptions.EmployeeNotFoundException;
import com.oms.model.Employee;

public class EmployeeRepository {

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * FROM employees";
		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				String empId = resultSet.getString("EmployeeID");
				String name = resultSet.getString("Name");
				LocalDateTime lastLogin = resultSet.getTimestamp("LastLogin").toLocalDateTime();
				boolean isLoggedIn = resultSet.getBoolean("isLoggedIn");

				Employee employee = new Employee(empId, name, lastLogin, isLoggedIn, "password****");
				employees.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	public Employee findByEmployeeId(String empId) throws EmployeeNotFoundException {
		String sql = "SELECT * FROM Employees WHERE EmployeeID = ?";
		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, empId);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return createEmployeeFromResultSet(resultSet);
				} else {
					throw new EmployeeNotFoundException("Employee not found with ID: " + empId);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // Employee not found
	}

	public boolean validateCredentials(String empId, String password) throws SQLException, EmployeeNotFoundException {
		Employee employee = findByEmployeeId(empId);
		System.out.println(employee);
		String h_password = hashThePassword(password);

		if (employee != null) {
			return employee.getHashedPassword().equals(h_password);
		} else {
			throw new EmployeeNotFoundException("Employee Not found!!");
		}
	}

	private String hashThePassword(String password) {
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
			e.printStackTrace();
			return null;
		}
	}

	public void updateLoginStatus(String empId, boolean isLoggedIn) throws SQLException {
		String sql = "UPDATE Employees SET IsLoggedIn = ? WHERE EmployeeID = ?";
		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setBoolean(1, isLoggedIn);
			statement.setString(2, empId);
			statement.executeUpdate();
		}
	}

	private Employee createEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
		String empId = resultSet.getString("EmployeeID");
		String name = resultSet.getString("Name");
		LocalDateTime lastLogin = resultSet.getTimestamp("LastLogin").toLocalDateTime();
		boolean isLoggedIn = resultSet.getBoolean("IsLoggedIn");
		String hashedPassword = resultSet.getString("Password");
		return new Employee(empId, name, lastLogin, isLoggedIn, hashedPassword);
	}
}
