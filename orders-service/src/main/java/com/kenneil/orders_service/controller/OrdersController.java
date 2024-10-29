package com.kenneil.orders_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kenneil.orders_service.model.OrderSummary;

@RestController
@RequestMapping("orders")
public class OrdersController {

	private final double APPLE_PRICE = 0.60;
	private final double ORANGE_PRICE = 0.25;

	@PostMapping("order")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderSummary getItemsFromOrder(@RequestBody Order order) {
		int apples = order.getApples();
		int oranges = order.getOranges();
		double totalCost = (apples * APPLE_PRICE) + (oranges * ORANGE_PRICE);
		
		return new OrderSummary(apples, oranges, totalCost);
	}
	
	@PostMapping("order/sale")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderSummary getItemsFromOrderSale(@RequestBody Order order) {
		int apples = order.getApples();
		int oranges = order.getOranges();
		
		//Buy one get one free sale on apples
		int appleSale = apples * 2;
		double appleCost = (appleSale * APPLE_PRICE)/2;
		
		//3 for the price of 2 on oranges
		int orangeSale = (oranges/ 3) * 3;
		double orangeCost = ((orangeSale * 2 * ORANGE_PRICE)/3) + ((oranges % 3)* ORANGE_PRICE);
		
		double totalCost = appleCost + orangeCost;

		return new OrderSummary(apples, oranges, totalCost);
	}

}
