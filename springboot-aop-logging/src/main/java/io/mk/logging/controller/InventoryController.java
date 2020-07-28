package io.mk.logging.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.mk.logging.model.Item;

@RestController
public class InventoryController {

	@GetMapping("item/{itemId}")
	public Item getItem(@PathVariable String itemId) {
		return new Item(itemId, "ITEM" + itemId, 8);
	}
}
