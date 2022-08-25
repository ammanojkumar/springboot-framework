package io.mk.batch.step;

import org.springframework.batch.item.ItemReader;

public class Reader implements ItemReader<String> {

	private String[] names = { "Manoj", "Raja", "Peter", "Jhon", "Rani" };
	private int count = 0;

	@Override
	public String read() {

		if (count < names.length) {
			return names[count++];
		}

		count = 0;
		return null;
	}

}