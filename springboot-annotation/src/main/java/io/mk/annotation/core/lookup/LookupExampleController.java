package io.mk.annotation.core.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LookupExampleController {

	@Autowired
	private SingletonPrintService bean;

	@GetMapping("print")
	public String print() throws Exception {
		bean.printDateTime();
		Thread.sleep(1000);
		bean.printDateTime();

		Thread.sleep(1000);
		bean.printDateTimeByLookup();
		Thread.sleep(1000);
		bean.printDateTimeByLookup();
		
		return "Lookup Example: DateTime printed in console";
	}

}
