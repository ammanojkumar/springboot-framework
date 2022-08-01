package com.exampe.ms.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Qualifier("g1")
public class GreetService1 implements GreetServiceInf {

	@Override
	public String sayHi(String name) {
		return "Hello " + name;
	}
}
