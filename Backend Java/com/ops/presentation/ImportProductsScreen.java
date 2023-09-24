package com.ops.presentation;

import java.sql.SQLException;
import java.util.List;

import com.oms.exceptions.ProductNotFoundException;
import com.oms.model.Product;
import com.oms.persistence.ProductRepository;
import com.oms.service.ProductService;

public class ImportProductsScreen {
	private ProductRepository productRepository;

	public ImportProductsScreen(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void importProducts() throws SQLException, ProductNotFoundException{
		
			ProductService productService = new ProductService();
			List<Product> importedProducts = productService.importProductsFromJsonFile();
			int successfulImports = 0;
		    int failedImports = 0;
			for (Product product : importedProducts) {
	            // Check if the product already exists in the database
	            Product existingProduct = productRepository.findbyProductId(product.getProductId());
				System.out.println(existingProduct);
	            if (existingProduct != null) {
	            	successfulImports++;
	            } else {
	    
	            	failedImports++;
	            }
	        }

	        // Print the counts of successful and failed imports
	        System.out.println("Imported " + successfulImports + " products successfully.");
	        System.out.println("Failed to import " + failedImports + " products.");
	}
}