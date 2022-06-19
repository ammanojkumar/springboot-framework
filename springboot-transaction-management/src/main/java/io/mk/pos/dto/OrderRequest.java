package io.mk.pos.dto;

import io.mk.pos.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

	private String customerId;
	private String productId;
	private Integer quantity;
	private PaymentInfo paymentInfo;
}
