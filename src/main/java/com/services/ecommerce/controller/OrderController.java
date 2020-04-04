package com.services.ecommerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.services.ecommerce.entity.Item;
import com.services.ecommerce.entity.Order;
import com.services.ecommerce.exception.ECommerceException;
import com.services.ecommerce.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private OrderService service;
	public OrderController(OrderService orderService) {
		this.service = orderService;
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAll(@RequestParam("emailId") String email){
		return new ResponseEntity<List<Order>>(service.getByEmailId(email), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Order> orderItems(@RequestParam("emailId") String email, @RequestBody List<Item> items) throws ECommerceException{
		return new ResponseEntity<Order>(service.orderItems(items, email), HttpStatus.OK);
	}
}
