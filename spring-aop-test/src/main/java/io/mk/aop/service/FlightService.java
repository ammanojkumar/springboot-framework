package io.mk.aop.service;

import org.springframework.stereotype.Service;

import io.mk.aop.model.Flight;

@Service
public class FlightService {

	public Flight getFlight(int flightId) {
		return new Flight();
	}
}
