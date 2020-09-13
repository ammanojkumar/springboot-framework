package io.mk.mbank.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

	private Map<String, Integer> accMap = new HashMap<>();

	public AccountService() {
		for (int i = 1; i < 11; i++) {
			accMap.put(String.valueOf(i), new Random().nextInt(5000));
		}
	}

	public String getAccountBalance(String accNumber) {
		return "$" + accMap.get(accNumber);
	}

}
