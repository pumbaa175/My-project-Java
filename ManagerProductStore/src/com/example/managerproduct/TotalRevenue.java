package com.example.managerproduct;

public class TotalRevenue {

	private int totalRevenue = 0;
	
	public void addTotalRevenue(int totalPay) {
		totalRevenue += totalPay;
	}

	public int getTotalRevenue() {
		return totalRevenue;
	}
}
