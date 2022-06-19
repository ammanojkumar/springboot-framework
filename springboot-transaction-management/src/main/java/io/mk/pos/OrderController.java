package io.mk.pos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mk.pos.dto.OrderAcknowledgement;
import io.mk.pos.dto.OrderRequest;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("product")
	public OrderAcknowledgement orderProduct(@RequestBody OrderRequest orderRequest) {
		System.out.println("ordering");
		return orderService.orderProduct(orderRequest);
	}

}
