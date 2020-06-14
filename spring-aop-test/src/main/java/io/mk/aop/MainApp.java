package io.mk.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import io.mk.aop.service.FlightService;

public class MainApp {

	@Autowired
	private static ApplicationContext appContext;

	@Autowired
	static FlightService flightService;

	public static void main(String[] args) {
		System.out.println("Hello World! " + appContext);
	}
}
