package com.example.demo.order;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Orders {
	
	public static enum DeliveryType {NORMAL, EXPRESS, NURYEONG}
	
	public static enum PaymentMethod {CARD, BANK, MEMORY, TOSIM_MOOD}
	
	public static enum DeliverStatus {COMPLETED, SHIPPING}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String receiverName;
	
	@Column(nullable = false)
	private String receiverPhone;
	
	@Column(nullable = false)
	private String deliveryAddress;
	
	@Column
	private String specialRequest;

	private LocalDateTime createdAt;
	
//	@Enumerated(EnumType.STRING)
	private DeliveryType deliveryType;
	
//	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	
//	@Enumerated(EnumType.STRING)
	private DeliverStatus status;

	public Orders(String receiverName, String receiverPhone, String deliveryAddress, String specialRequest,
			DeliveryType deliveryType, PaymentMethod paymentMethod) {
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.deliveryAddress = deliveryAddress;
		this.specialRequest = specialRequest;
		this.deliveryType = deliveryType;
		this.paymentMethod = paymentMethod;
		this.status = status.SHIPPING;
		this.createdAt = LocalDateTime.now();
	}
	
	
}
