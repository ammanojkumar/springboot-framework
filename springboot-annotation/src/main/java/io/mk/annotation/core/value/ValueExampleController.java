package io.mk.annotation.core.value;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueExampleController {

	@Autowired
	private ApplicationPropertiesService applicationValueService;

	@Autowired
	private CustomPropertiesService customValueService;

	@Autowired
	private ConfigurationPropertiesValueService bulkValueService;

	final static String newLine = "\n";

	@GetMapping("value")
	public String getValues() {
		StringBuilder builder = new StringBuilder();
		builder.append(applicationValueService.getValues()).append(newLine).append(customValueService.getValues())
				.append(newLine).append(bulkValueService.getValues());

		return builder.toString();
	}

}
