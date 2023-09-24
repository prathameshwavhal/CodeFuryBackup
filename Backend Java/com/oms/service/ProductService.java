package com.oms.service;

import java.io.File;

import java.io.FileReader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.oms.exceptions.ProductNotFoundException;
import com.oms.model.Product;

import com.oms.persistence.ProductRepository;

public class ProductService {
	private ProductRepository productRepository;
	
	public ProductService() {
		this.productRepository = new ProductRepository();
	}

	public List<Product> importProductsFromJsonFile() throws SQLException {
		List<Product> importedProducts = new ArrayList<>();

		try {
			JSONTokener tokener = new JSONTokener(new FileReader("products.json"));
	        JSONArray jsonArray = new JSONArray(tokener);
	
	        for (int i = 0; i < jsonArray.length(); i++) 
	        {
	        	JSONObject productObject = jsonArray.getJSONObject(i);
	            Product product = new Product();
	            product.setProductId(productObject.getInt("ProductID"));
	            product.setName(productObject.getString("Name"));
	            product.setPrice(productObject.getDouble("Price"));
	            String categoryString = productObject.getString("Category");
	            Product.ProductCategory category = Product.ProductCategory.valueOf(categoryString);
	            product.setCategory(category);
	            
	            importedProducts.add(product);
	            // Insert product into the database
	            productRepository.insertProduct(product);
	        }
	        
	        
			

		} catch (IOException | JSONException e) {
			e.printStackTrace();
			// Handle exceptions (e.g., file not found, JSON parsing errors)
		}

		return importedProducts;
	}
	
	public Product getProductById(int productId)
	{
		Product pro = null;
		try {
			pro = productRepository.findbyProductId(productId);
			
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}
}
