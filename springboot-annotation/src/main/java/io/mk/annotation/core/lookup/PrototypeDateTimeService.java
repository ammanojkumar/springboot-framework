package io.mk.annotation.core.lookup;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeDateTimeService {

	private String dateTimeString = LocalDateTime.now().toString();

	public String getDateTime() {
		return dateTimeString;
	}
}
