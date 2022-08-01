package io.sb.test;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MyPrototypeBean {

	public String getDateTime() {
		return LocalDateTime.now().toString();
	}
}
