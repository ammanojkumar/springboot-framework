package io.mk.pos.util;

import java.util.HashMap;
import java.util.Map;

import io.mk.pos.exception.OutOfStockException;

public class ProductUtil {

	private static Map<String, Integer> productAvailabilityMap = new HashMap<String, Integer>();

	static {
		productAvailabilityMap.put("p1", 5);
		productAvailabilityMap.put("p2", 8);
		productAvailabilityMap.put("p3", 1);
	}

	public static boolean validateAvailablity(String productId, Integer quantity) {
		if (productAvailabilityMap.get(productId).compareTo(quantity) == -1) {
			throw new RuntimeException(new OutOfStockException("Out Of Stock " + quantity));
		}
		return true;
	}
}