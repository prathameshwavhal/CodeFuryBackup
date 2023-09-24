package com.ops.presentation;

import java.util.List;

import com.oms.exceptions.OrderNotFoundException;
import com.oms.exceptions.ProductNotFoundException;
import com.oms.model.Invoice;
import com.oms.model.Product;
import com.oms.service.InvoiceService;

public class InvoiceScreen
{
	
	public void displayInvoice(int orderId) throws OrderNotFoundException,ProductNotFoundException{
		Invoice invoice = null;
		try {
			invoice = InvoiceService.displayInvoice(orderId);
		} 
		catch (OrderNotFoundException | ProductNotFoundException e) {
	
			throw e;
		} 
		System.out.println("Invoice Details:");
		System.out.println("Invoice ID: " + invoice.getInvoiceId());
		System.out.println("Invoice Date: " + invoice.getInvoiceDate());
		System.out.println("Order ID: " + invoice.getOrderId());
		System.out.println("Customer Name: " + invoice.getCustomer());

		// Print other invoice details in a similar manner
		System.out.println("GST Type: " + invoice.getGstType());
		System.out.println("Total GST Amount: " + invoice.getTotalGSTAmount());
		System.out.println("Total Invoice Value: " + invoice.getTotalInvoiceValue());
		System.out.println("Invoice Status: " + invoice.getStatus());
		System.out.println("Total Order Value: " + invoice.calculateTotalOrderValue());

		// If you have a productList, you can iterate over it and print each product's
		// details
		System.out.println("\n Product Details:\n");
		List<Product> productList = invoice.getProductList();
		if (productList != null) {
			System.out.println("Product List:");
			for (Product product : productList) {
				System.out.println("Product ID: " + product.getProductId());
				System.out.println("Product Name: " + product.getName());
			}
		} else {
			System.out.println("Invoice not found with OrderId: " + orderId);
		}
	}
}
