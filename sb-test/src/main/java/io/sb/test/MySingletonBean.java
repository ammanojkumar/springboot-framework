package io.sb.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class MySingletonBean {

	@Autowired
	MyPrototypeBean bean;

	public void showMessage() {
		System.out.println("Hi, the time is " + getPrototypeBean().getDateTime());
	}

	@Lookup
	public MyPrototypeBean getPrototypeBean() {
		return null;
	}
}
