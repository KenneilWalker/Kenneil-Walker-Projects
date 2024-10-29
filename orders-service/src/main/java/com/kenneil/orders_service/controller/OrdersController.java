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
		// return orderService.calculateOrder(order);
		return new OrderSummary(apples, oranges, totalCost);
	}

}
