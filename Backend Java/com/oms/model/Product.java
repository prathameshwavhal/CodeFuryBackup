package com.oms.model;

public class Product {
	private int productId;
	private String name;
	private double price;
	private ProductCategory category;

	public enum ProductCategory {
		Level_1, Level_2, Level_3
	}
	
	public Product()
	{
		
	}
	// Constructors
	public Product(int productId, String name, double price, ProductCategory category) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public Product(String name2, double price2) {
		this.name = name2;
		this.price = price2;
	}

	// Getters and setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category != other.category)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product{" + "productId=" + productId + ", name='" + name + '\'' + ", price=" + price + ", category="
				+ category + '}';
	}
}
