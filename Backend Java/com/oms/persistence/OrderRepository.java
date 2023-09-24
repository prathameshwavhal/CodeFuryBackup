package com.oms.persistence;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oms.model.Customer;
import com.oms.model.Order;
import com.oms.model.Order.OrderStatus;
import com.oms.exceptions.*;

public class OrderRepository {
	private CustomerRepository customerRepository = new CustomerRepository();

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		String sql = "SELECT * FROM Orders";

		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				int orderId = resultSet.getInt("OrderID");
				Date orderDate = resultSet.getDate("OrderDate");
				String customerShippingAddress = resultSet.getString("ShippingAddress");
				int customerId = resultSet.getInt("CustomerID");
				Customer customer = customerRepository.findByCustomerId(customerId);
				String customerName = customer.getName();
				String productIds = resultSet.getString("ProductIDs");

				double totalOrderValue = resultSet.getDouble("TotalOrderValue");
				double shippingCost = resultSet.getDouble("shippingCost");
				String shippingAgency = resultSet.getString("ShippingAgency");
				String statusString = resultSet.getString("Status");

				OrderStatus status;
				try {
					status = OrderStatus.valueOf(statusString);
				} catch (IllegalArgumentException e) {
					// Handle invalid status string
					status = OrderStatus.PENDING; // Default to PENDING
				}

				Order order = new Order(orderId, orderDate, customerName, customerShippingAddress, productIds,
						totalOrderValue, shippingCost, shippingAgency, status);
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle or log the SQL exception
		}

		return orders;
	}

//	public List<Product> getProductListFromOrderId(int orderId) {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		List<Product> productList = new ArrayList<>();
//
//		try {
//			connection = DatabaseUtil.getConnection();
//			String sql = "SELECT product_id FROM order_products WHERE order_id = ?";
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, orderId);
//			resultSet = preparedStatement.executeQuery();
//
//			while (resultSet.next()) {
//				int productId = resultSet.getInt("product_id");
//
//				// Retrieve product details from the 'products' table based on the productId
//				Product product = getProductDetails(productId);
//
//				if (product != null) {
//					productList.add(product);
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace(); // Handle or log the SQL exception
//		}
//
//		return productList;
//	}
//
//	private Product getProductDetails(int productId) throws SQLException {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		Product product = null;
//
//		try {
//			connection = DatabaseUtil.getConnection();
//			String sql = "SELECT * FROM products WHERE product_id = ?";
//			preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, productId);
//			resultSet = preparedStatement.executeQuery();
//
//			if (resultSet.next()) {
//				// Extract product information from the result set
//				String name = resultSet.getString("name");
//				double price = resultSet.getDouble("price");
//				String categoryStr = resultSet.getString("category");
//
//				// Convert the category string to ProductCategory enum
//				ProductCategory category = ProductCategory.valueOf(categoryStr);
//
//				// Create a Product object with the retrieved data
//				product = new Product();
//				product.setProductId(productId);
//				product.setName(name);
//				product.setPrice(price);
//				product.setCategory(category);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace(); // Handle or log the SQL exception
//		}
//		return product;
//	}

	public List<Order> getAllOrdersByCustomerId(int customerId) {
		List<Order> customerOrders = new ArrayList<>();
		String sql = "SELECT * FROM Orders WHERE CustomerID = ?";

		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, customerId);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					int orderId = resultSet.getInt("OrderID");
					Date orderDate = resultSet.getDate("OrderDate");
					String customerShippingAddress = resultSet.getString("ShippingAddress");
					int customerId1 = resultSet.getInt("CustomerID");
					Customer customer = customerRepository.findByCustomerId(customerId1);
					String customerName = customer.getName();
					String productIds = resultSet.getString("ProductIDs");

					double totalOrderValue = resultSet.getDouble("TotalOrderValue");
					double shippingCost = resultSet.getDouble("shippingCost");
					String shippingAgency = resultSet.getString("ShippingAgency");
					String statusString = resultSet.getString("Status");

					OrderStatus status;
					try {
						status = OrderStatus.valueOf(statusString);
					} catch (IllegalArgumentException e) {
						// Handle invalid status string
						status = OrderStatus.PENDING; // Default to PENDING
					}

					Order order = new Order(orderId, orderDate, customerName, customerShippingAddress, productIds,
							totalOrderValue, shippingCost, shippingAgency, status);
					customerOrders.add(order);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customerOrders;
	}

	public Order findOrderById(int orderId) throws OrderNotFoundException {
	    String sql = "SELECT * FROM Orders WHERE OrderID = ? ";

	    try (Connection connection = DatabaseUtil.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        preparedStatement.setInt(1, orderId);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                // Retrieve order data from the result set and create an Order object
	                int orderIdResult = resultSet.getInt("OrderID");
	                Date orderDate = resultSet.getDate("OrderDate");
	                String productids =resultSet.getString("ProductIDs");
	                
	                // Retrieve other fields as needed
	                
	                // Create an Order object
	                Order order = new Order();
	                order.setOrderId(orderIdResult);
	                order.setOrderDate(orderDate);
	                order.setProductIds(productids);
	                // Set other fields accordingly
	             
	                return order;
	            } else {
	                // If the order is not found, throw a custom exception
	                throw new OrderNotFoundException("Order with ID " + orderId + " not found.");
	            }
	        }
	    } catch (SQLException e) {
	        // Handle any exceptions (e.g., SQLException) or log them
	  
	        throw new OrderNotFoundException("Error while retrieving order with ID " + orderId + ".");
	    }
	}


}
