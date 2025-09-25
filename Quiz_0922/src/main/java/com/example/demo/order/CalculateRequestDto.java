package com.example.demo.order;

import com.example.demo.order.Orders.DeliveryType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateRequestDto {
	private DeliveryType deliveryType;
}
