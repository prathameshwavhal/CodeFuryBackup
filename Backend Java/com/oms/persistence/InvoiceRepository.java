package com.oms.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oms.exceptions.OrderNotFoundException;
import com.oms.exceptions.ProductNotFoundException;
import com.oms.model.Invoice;
import com.oms.model.Order;
import com.oms.model.Product;
import com.oms.model.Invoice.GSTType;
import com.oms.model.Invoice.InvoiceStatus;
import com.oms.model.Order.OrderStatus;

public class InvoiceRepository {
	private static ProductRepository productRepository = new ProductRepository();
	private static OrderRepository orderRepository = new OrderRepository();
	
	public void generateInvoice(Invoice invoice) {
		// Update the order's status to reflect that an invoice has been generated
		try (Connection connection = DatabaseUtil.getConnection()) {

			// Update the order status
			String updateOrderStatusSql = "UPDATE Orders SET Status = ? WHERE OrderID = ?";
			try (PreparedStatement updateOrderStatusStatement = connection.prepareStatement(updateOrderStatusSql)) {
				updateOrderStatusStatement.setString(1, OrderStatus.INVOICED.toString());
				updateOrderStatusStatement.setInt(2, invoice.getOrderId());
				updateOrderStatusStatement.executeUpdate();
			}

			String insertInvoiceSql = "INSERT INTO Invoices (InvoiceID, InvoiceDate, OrderID, CustomerID, TotalInvoiceValue, TotalGSTAmount, Status, total_order_value) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			try (PreparedStatement insertInvoiceStatement = connection.prepareStatement(insertInvoiceSql)) {
				// Set the parameters for the prepared statement
				insertInvoiceStatement.setInt(1, invoice.getInvoiceId()); // Set the invoiceId explicitly
				insertInvoiceStatement.setDate(2, new java.sql.Date(invoice.getInvoiceDate().getTime()));
				insertInvoiceStatement.setInt(3, invoice.getOrderId());
				insertInvoiceStatement.setInt(4, invoice.getCustomerId().getCustomerId());
				insertInvoiceStatement.setDouble(5, invoice.getTotalInvoiceValue());
				insertInvoiceStatement.setDouble(6, invoice.getTotalGSTAmount());
				insertInvoiceStatement.setString(7, invoice.getStatus().toString());
				insertInvoiceStatement.setDouble(8, invoice.calculateTotalOrderValue());

				// Execute the INSERT statement
				insertInvoiceStatement.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/*
	 * //Method for generating invoice of all orders at 12 pm everyday public void
	 * generateInvoicesForApprovedOrders() { // Retrieve all approved orders from
	 * the previous day List<Order> approvedOrders =
	 * OrderRepository.getApprovedOrdersFromPreviousDay();
	 * 
	 * for (Order order : approvedOrders) {
	 * 
	 * // Create an invoice and save it to the database
	 * invoiceRepository.generateInvoice(); } }
	 */

	public static Invoice getInvoice(int orderId) throws ProductNotFoundException 
	{
		 try (Connection connection = DatabaseUtil.getConnection()) 
		 {
	           String selectInvoiceSql = "SELECT * FROM Invoices WHERE OrderID = ?";
	           try (PreparedStatement selectInvoiceStatement = connection.prepareStatement(selectInvoiceSql)) {
	                selectInvoiceStatement.setInt(1, orderId);
	                try (ResultSet resultSet = selectInvoiceStatement.executeQuery()) {
	                    if (resultSet.next()) {
	                        // Create a new Invoice instance and populate it with data from the database
	                        Invoice invoice = new Invoice();
	                        invoice.setInvoiceId(resultSet.getInt("InvoiceID"));
	                        invoice.setInvoiceDate(resultSet.getDate("InvoiceDate"));
	                        invoice.setOrderId(resultSet.getInt("OrderID"));
	                        invoice.setCustomer(resultSet.getString("CustomerName"));
	                        
	                        String gstTypeString = resultSet.getString("GSTType");
	                        invoice.setGstType(GSTType.valueOf(gstTypeString.toUpperCase()));
	                        
	                        invoice.setTotalGSTAmount(resultSet.getDouble("TotalGSTAmount"));
	                        invoice.setTotalInvoiceValue(resultSet.getDouble("TotalInvoiceValue"));
	                        
	                        String statusString = resultSet.getString("Status");
	                        invoice.setStatus(InvoiceStatus.valueOf(statusString.toUpperCase()));
	                        Order order = null;
							try {
								order = orderRepository.findOrderById(orderId);
							} catch (OrderNotFoundException e) {
								System.out.println("OrderNot found");
							}
	                		
	                		
	                		invoice.setProductList(getProductLists(order));
	                        
	                        
	                        return invoice;
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return null; // Return n
		
	}
	private static List<Product> getProductLists(Order order) throws ProductNotFoundException
	{
		List<Product> products =  new ArrayList<>();
		
		String ids = order.getProductIds();
		String[] productIdTokens = ids.split(",");
		
		for(String productId: productIdTokens )
		{
			int id = Integer.parseInt(productId.trim());
			
			try {
				Product product1 =productRepository.findbyProductId(id);
				products.add(product1);
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				throw e;
			}
			
		}
		return products;
	}


}
