package com.oms.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.oms.exceptions.EmployeeNotFoundException;
import com.oms.exceptions.ProductNotFoundException;
import com.oms.model.Employee;
import com.oms.model.Product;
import com.oms.model.Invoice.InvoiceStatus;
import com.oms.model.Product.ProductCategory;

public class ProductRepository 
{
	
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		String sql = "SELECT * FROM Products";

		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				int productId = resultSet.getInt("ProductId");
				String name = resultSet.getString("Name");
				double price = resultSet.getDouble("Price");
				String category = resultSet.getString("Category");
				ProductCategory product_category = ProductCategory.valueOf(category);

				Product product = new Product(productId, name, price, product_category);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	

	public Product findbyProductId(int productId) throws ProductNotFoundException {
		String sql = "SELECT * FROM Products WHERE ProductID = ?";
		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, productId);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					int id=resultSet.getInt("ProductID");
					String name = resultSet.getString("Name");
					double price= resultSet.getDouble("Price");
					String category = resultSet.getString("Category");
					
					Product product=new Product();
					product.setProductId(id);
					product.setName(name);
					product.setPrice(price);
					
					product.setCategory(ProductCategory.valueOf(category));
					
					return product;
				} else {
					throw new ProductNotFoundException("Product not found with ID: " + productId);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // Employee not found
	}

	public void insertProduct(Product product) throws SQLException {
	
		try (Connection connection = DatabaseUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Products (ProductID, Name, Price, Category) VALUES (?, ?, ?, ?)")) {

	        preparedStatement.setInt(1, product.getProductId());
	        preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getPrice());
	        String categoryString = product.getCategory().toString();
	        preparedStatement.setString(4, categoryString);
	        preparedStatement.executeUpdate();
	    }
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	

}
