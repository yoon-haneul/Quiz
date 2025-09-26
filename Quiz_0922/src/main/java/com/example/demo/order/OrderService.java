package com.example.demo.order;

import org.springframework.stereotype.Service;

import com.example.demo.order.Orders.DeliveryType;
import com.example.demo.order.Orders.PaymentMethod;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	public void process(OrderDTO orderDTO) {
		
		DeliveryType deliveryType;
		PaymentMethod paymentMethod;
		
		if(orderDTO.getDeliveryType()==DeliveryType.NORMAL) {
			deliveryType = DeliveryType.NORMAL;
		} else if(orderDTO.getDeliveryType()==DeliveryType.EXPRESS) {
			deliveryType = DeliveryType.EXPRESS;
		} else if(orderDTO.getDeliveryType()==DeliveryType.NURYEONG) {
			deliveryType = DeliveryType.NURYEONG;
		} else {
			throw new IllegalArgumentException("유효하지 않은 배송 방법입니다.");
		}
		
		if(orderDTO.getPaymentMethod()==PaymentMethod.CARD) {
			paymentMethod = PaymentMethod.CARD;
		} else if(orderDTO.getPaymentMethod()==PaymentMethod.BANK) {
			paymentMethod = PaymentMethod.BANK;
		} else if(orderDTO.getPaymentMethod()==PaymentMethod.MEMORY) {
			paymentMethod = PaymentMethod.MEMORY;
		} else if (orderDTO.getPaymentMethod()==PaymentMethod.TOSIM_MOOD) {
			paymentMethod = PaymentMethod.TOSIM_MOOD;
		} else {
			throw new IllegalArgumentException("유효하지 않은 결제 방법입니다.");
		}
		
		Orders order = new Orders(
				orderDTO.getReceiverName(),
				orderDTO.getReceiverPhone(),
				orderDTO.getDeliveryAddress(),
				orderDTO.getSpecialRequest(),
				deliveryType,
				paymentMethod
				);
		
		if(orderDTO.isPrivacyAgreed()==true && orderDTO.isTermsAgreed()==true) {
			this.orderRepository.save(order);
		} else {
			throw new IllegalArgumentException("약관에 동의하지 않으면 주문할 수 없습니다.");
		}
		
	}

}
