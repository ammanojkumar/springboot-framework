package io.mk.scheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StockMarketService {

	Map<String, Integer> stockPriceMap = new HashMap<>();
	static List<String> stockList = new ArrayList<>();
	Random random = new Random();

	static {
		stockList.addAll(Arrays.asList(new String[] { "stock1", "stock2", "stock3", "stock4", "stock5" }));
	}

	@Scheduled(cron = "1/8 * * * * *")
	public void printCurrentMarketPrice() {
		System.out.println(stockPriceMap);
	}

	@Scheduled(fixedDelay = 3000)
	public void changeMarketPrice() {
		String stock = stockList.get(random.nextInt(5));
		Integer change = random.nextInt(50);
		if (stockPriceMap.containsKey(stock)) {
			change *= (random.nextBoolean() ? 1 : -1);
		}
		stockPriceMap.put(stock, change);
		System.out.println("Stock price has changed.. " + LocalDateTime.now());
	}
}
