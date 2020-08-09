package io.mk.jwt.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@RequestMapping("accbalance/{accNo}")
	public Integer getBalance(@PathVariable Integer accNo) {
		return 99;
	}
}
