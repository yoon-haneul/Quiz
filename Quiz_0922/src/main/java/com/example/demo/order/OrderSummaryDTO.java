package com.example.demo.order;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderSummaryDTO {
	
	public OrderSummaryDTO(long subtotal, long shippingFee, long totalAmount) {
		this.subtotal = subtotal;
		this.shippingFee = shippingFee;
		this.totalAmount = totalAmount;
	}

	private long subtotal;
	
	private long shippingFee;
	
	private long totalAmount;
	
	
	
	
}
