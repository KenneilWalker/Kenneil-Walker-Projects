package com.kenneil.orders_service.model;

public class OrderSummary {
	
	private int apples;
	private int oranges;
	private double totalCost;
	
	public OrderSummary(int apples, int oranges, double totalCost) {
		this.apples = apples;
		this.oranges = oranges;
		this.totalCost = totalCost;
	}

	public int getApples() {
		return apples;
	}

	public void setApples(int apples) {
		this.apples = apples;
	}

	public int getOranges() {
		return oranges;
	}

	public void setOranges(int oranges) {
		this.oranges = oranges;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
