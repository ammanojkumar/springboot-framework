package io.mk.annotation.core.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class SingletonPrintService {

	@Autowired
	private PrototypeDateTimeService prototypeDateTimeService;

	@Lookup
	public PrototypeDateTimeService getPrototypeBean() {
		return null;
	}

	public void printDateTime() {
		System.out.println("Using Autowired: " + prototypeDateTimeService.getDateTime());
	}

	public void printDateTimeByLookup() {
		System.out.println("Using Lookup   : " + getPrototypeBean().getDateTime());
	}

}
