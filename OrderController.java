package com.flm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flm.dto.OrderRequestDTO;
import com.flm.dto.OrderResponseDTO;
import com.flm.service.OrderItemService;
import com.flm.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@PostMapping("/buy")
	public OrderResponseDTO placeOrder(@RequestBody List<OrderRequestDTO> orderRequestDTOList) {
		return orderService.placeOrder(orderRequestDTOList);
	}
	
	@GetMapping("/info/{id}")
	public OrderResponseDTO getOrderInfo(@PathVariable( name = "id")long orderId) {
		return orderService.getOrderInfo(orderId);
	}
	
	@DeleteMapping("/cancel/{id}")
	public void cancelOrderItem(@PathVariable(name = "id") int orderItemId) {
		orderItemService.canelOrderItem(orderItemId);
	}
}
