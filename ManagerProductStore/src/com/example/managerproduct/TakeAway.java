package com.example.managerproduct;

public class TakeAway{
	
	private Product productTakeAway = new Product();
	
	public TakeAway() {
		
	}

	public Product getProductTakeAway() {
		return productTakeAway;
	}
	
	public void addProduct(String productName, int productQuantity) {
		productTakeAway.addProduct(productName, productQuantity);
	}
}
