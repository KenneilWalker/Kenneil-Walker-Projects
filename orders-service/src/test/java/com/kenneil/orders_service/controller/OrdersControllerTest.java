package com.kenneil.orders_service.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = OrdersController.class)
public class OrdersControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("junit test case for posttItemsFromOrder in OrdersController class ")
	public void getItemsFromOrder() throws Exception {

		String requestBody = "{\"apples\": 2, \"oranges\": 2}";

		mockMvc.perform(MockMvcRequestBuilders.post("/orders/order").contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)).andExpect(jsonPath("$.apples", is(2))).andExpect(jsonPath("$.oranges", is(2)))
				.andExpect(jsonPath("$.totalCost", is(1.7)));

	}

}
