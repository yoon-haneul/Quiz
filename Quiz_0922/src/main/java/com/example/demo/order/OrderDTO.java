package com.example.demo.order;

import com.example.demo.order.Orders.DeliveryType;
import com.example.demo.order.Orders.PaymentMethod;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {
	
	@NotBlank
	private String receiverName;
	
	
	@NotBlank
	private String receiverPhone;
	@NotBlank
	private String deliveryAddress;
	@NotBlank
	private String specialRequest;
	@NotBlank
	private boolean termsAgreed;
	@NotBlank
	private boolean privacyAgreed;
	
	@NotBlank
	private DeliveryType deliveryType;
	
	@NotBlank
	private PaymentMethod paymentMethod;
}
