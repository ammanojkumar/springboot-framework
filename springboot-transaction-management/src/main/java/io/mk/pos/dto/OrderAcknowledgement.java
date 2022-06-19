package io.mk.pos.dto;

import io.mk.pos.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderAcknowledgement {

	private String transactionId;
	private String customerId;
	private String status;
	private Product productInfo;

}
