package com.kenneil.orders_service.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kenneil.orders_service.model.OrderSummary;

@Service
public class OrdersService {

	private final Map<Integer, OrderSummary> orders = new HashMap<>();
	private int idCounter = 1;

	public OrderSummary getOrderById(int id) {
		return orders.get(id);
	}

	public void saveOrder(OrderSummary orderSummary) {
		int orderId = idCounter++;
		orders.put(orderId, orderSummary);

	}

	public Collection<OrderSummary> getAllOrders() {
		// TODO Auto-generated method stub
		return orders.values();
	}

}
