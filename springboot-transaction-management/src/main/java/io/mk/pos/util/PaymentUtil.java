package io.mk.pos.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import io.mk.pos.exception.InsufficientBalanceException;

public class PaymentUtil {

	private static Map<String, BigDecimal> accountMap = new HashMap<String, BigDecimal>();

	static {
		accountMap.put("a1", new BigDecimal(8000));
		accountMap.put("a2", new BigDecimal(9000));
		accountMap.put("a3", new BigDecimal(8500));
	}

	public static boolean validateBalance(String accNum, BigDecimal amount) {
		if (accountMap.get(accNum).compareTo(amount) == -1) {
			throw new RuntimeException(new InsufficientBalanceException("Insufficient Balance" + amount));
		}
		return true;
	}
}