package com.example.demo.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderAPIController {
	
	
	@PostMapping("/calculate")
	public OrderSummaryDTO calculateOrder(
			@RequestBody CalculateRequestDto request) {
		
		int shippingFee = 0;
		int subtotal = 500; // 물품 가격
		
		if(request.getDeliveryType().equals("EXPRESS")) {
			shippingFee = 10000;
		} 
		
		int totalAmount = subtotal + shippingFee + 3000;
		
		return new OrderSummaryDTO(subtotal, shippingFee, totalAmount);
	}
}
