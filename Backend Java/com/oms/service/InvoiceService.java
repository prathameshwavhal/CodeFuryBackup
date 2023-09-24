package com.oms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.oms.exceptions.OrderNotFoundException;
import com.oms.exceptions.ProductNotFoundException;
import com.oms.model.Invoice;
import com.oms.model.Order;
import com.oms.model.Product;
import com.oms.model.Invoice.GSTType;
import com.oms.model.Invoice.InvoiceStatus;
import com.oms.persistence.InvoiceRepository;
import com.oms.persistence.OrderRepository;
import com.oms.persistence.ProductRepository;

public class InvoiceService {
	private static OrderRepository orderRepository = new OrderRepository();
	private static ProductRepository productRepository =new ProductRepository();
	private static InvoiceRepository invoiceRepository =new InvoiceRepository();
	
	public static Invoice generateInvoice(int orderId) throws OrderNotFoundException, ProductNotFoundException {
		// Fetch the Order from the database using the provided orderId
	
		Order order = orderRepository.findOrderById(orderId);

		if (order != null) {
			// Create a new Invoice instance
			Invoice invoice = new Invoice();

			// Set the attributes of the invoice based on the Order and other parameters
			invoice.setInvoiceDate(new Date()); // Set the invoice date to the current date
			//invoice.setOrderId(order); // Set the associated order
			invoice.setCustomer(order.getCustomerName()); // Set the customer from the order
			invoice.setProductList(getProductLists(order)); // Set the products from the order
			invoice.setGstType(GSTType.SAME_STATE); // Set the GST type (you can customize this)
			invoice.setTotalGSTAmount(calculateTotalGST(order)); // Calculate and set the total GST amount
			invoice.setTotalInvoiceValue(calculateTotalInvoiceValue(order)); // Calculate and set the total invoice
																				// value
			invoice.setStatus(InvoiceStatus.UNPAID); // Set the initial status to UNPAID (you can customize this)
			invoice.setTotalInvoiceValue(order.getTotalOrderValue()); // Set the total order value from the order

			// Save the generated invoice in your database or perform any other necessary
			// operations
			//return invoice;
			invoiceRepository.generateInvoice(invoice);
			return invoice;
			
		}
		return null; // Return null if the order with the provided orderId is not found
	}

	private static double calculateTotalGST(Order order) throws ProductNotFoundException {
		List<Product> productList = getProductLists(order);
		double totalGST = 0.0;

		// Check if the product list is not null
		if (productList != null) {
			for (Product product : productList) {
				// Determine the GST rate based on the GSTType of the invoice
				//GSTType gstType = order.getInvoice().getGstType();
				//double gstRate = (gstType == GSTType.INTER_STATE) ? 0.1 : 0.05;
				double gstRate =0.05;
				// Calculate the GST for each product and add it to the total
				double productValue = product.getPrice();
				double gstAmount = productValue * gstRate;
				totalGST += gstAmount;
			}
		}

		return totalGST;
	}

	private static double calculateTotalInvoiceValue(Order order) throws ProductNotFoundException {
		double totalOrderValue = order.getTotalOrderValue();
		double totalGST = calculateTotalGST(order);

		// Calculate the total invoice value as the sum of total order value and total
		// GST
		double totalInvoiceValue = totalOrderValue + totalGST;

		return totalInvoiceValue;
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

	public static Invoice displayInvoice(int orderId) throws OrderNotFoundException,ProductNotFoundException {
		// TODO Auto-generated method stub
		
		Invoice invoice = InvoiceRepository.getInvoice(orderId);
		
		
		return invoice;
	}
	
	
	
}
