package io.mk.atm.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url = "http://desktop-ms1g9rh:7001/", name = "insurance-service")
public interface AccFeignClient {

	@RequestMapping(value = "balance/{accNumber}")
	public String getBalance(@PathVariable String accNumber);
}
