package com.example.demo.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OrderController {
	
	private OrderService orderService;
	
	@GetMapping("/order/direct")
	public String showOrder(Model model,
			OrderDTO orderDTO
			) {
//			,OrderTestDTO productDTO) {
		
		model.addAttribute("orderDTO", orderDTO);
//		model.addAttribute("orderItem", productDTO);
		model.addAttribute("orderSummary", new OrderSummaryDTO());
		
		return "order";
	}
	
	@PostMapping("/order/process")
	public String orderProcess(OrderDTO orderDTO,
			BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "/order";
		}
		
		this.orderService.process(orderDTO);
		
		return "redirect:/";
	}
	
	
}
