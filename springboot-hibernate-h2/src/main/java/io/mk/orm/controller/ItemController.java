package io.mk.orm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.mk.orm.model.Item;
import io.mk.orm.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping("item")
	public ResponseEntity<Item> saveItem(@RequestBody Item item) {
		return new ResponseEntity<>(itemService.saveItem(item), HttpStatus.CREATED);
	}

	@PutMapping("updateitem")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) {
		Item itemResp = itemService.updateItem(item);
		return new ResponseEntity<>(itemResp, HttpStatus.CREATED);
	}

	@GetMapping("item/{id}")
	public ResponseEntity<Item> getItem(@PathVariable Integer id) {
		Item item = itemService.getItem(id);
		return new ResponseEntity<>(item, HttpStatus.NOT_FOUND);
	}

	@GetMapping("items")
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> list = itemService.getAllItems();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@DeleteMapping("item/{id}")
	public ResponseEntity<HttpStatus> deleteItem(@PathVariable Integer id) {
		itemService.deleteItem(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
