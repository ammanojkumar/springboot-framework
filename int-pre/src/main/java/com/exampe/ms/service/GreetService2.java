package com.exampe.ms.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("g2")
public class GreetService2 implements GreetServiceInf {

	@Override
	public String sayHi(String name) {
		return "Hi " + name;
	}
}
