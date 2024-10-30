package com.kenneil.orders_service.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kenneil.orders_service.service.OrdersService;
import com.kenneil.orders_service.model.OrderSummary;

@RestController
@RequestMapping("orders")
public class OrdersController {

	private static final double APPLE_PRICE = 0.60;
	private static final double ORANGE_PRICE = 0.25;
	
	
	OrdersService ordersService;
	
	@Autowired
	public OrdersController(OrdersService orderService) {
		this.ordersService = orderService;
	}

	@PostMapping("order")
	@ResponseStatus(code = HttpStatus.OK)
	public OrderSummary getItemsFromOrder(@RequestBody Order order) {
		int apples = order.getApples();
		int oranges = order.getOranges();
		double totalCost = (apples * APPLE_PRICE) + (oranges * ORANGE_PRICE);
		
		OrderSummary orderSummary = new OrderSummary(apples, oranges, totalCost);
		ordersService.saveOrder(orderSummary);
		return orderSummary;
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
		OrderSummary orderSummary = new OrderSummary(appleSale,orangeSale,totalCost);
		ordersService.saveOrder(orderSummary);


		return new OrderSummary(appleSale, orangeSale, totalCost);
	}
	
	@GetMapping("/{id}")
	public OrderSummary getOrderById(@PathVariable int id) {
		return ordersService.getOrderById(id);
	}
	
	@GetMapping("/allOrders")
	public Collection<OrderSummary> getAllOrders(){
		return ordersService.getAllOrders();

	}

}
