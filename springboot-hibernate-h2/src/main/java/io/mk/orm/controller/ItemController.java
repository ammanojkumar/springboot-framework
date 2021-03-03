package io.mk.orm.controller;

import java.util.List;
import java.util.Optional;

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
import io.mk.orm.repostory.ItemRepository;

@RestController
public class ItemController {

	@Autowired
	private ItemRepository itemRepo;

	@PostMapping("item")
	public ResponseEntity<Item> saveItem(@RequestBody Item item) {
		return new ResponseEntity<>(itemRepo.save(item), HttpStatus.CREATED);
	}

	@PutMapping("item")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) {
		return new ResponseEntity<>(itemRepo.save(item), HttpStatus.OK);
	}

	@GetMapping("item/{id}")
	public ResponseEntity<Item> getItem(@PathVariable String id) {
		Optional<Item> item = itemRepo.findById(id);

		if (item.isPresent()) {
			return new ResponseEntity<>(item.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("items")
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> list = itemRepo.findAll();

		if (list.isEmpty() || list.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@DeleteMapping("item/{id}")
	public ResponseEntity<HttpStatus> deleteItem(@PathVariable String id) {
		Optional<Item> item = itemRepo.findById(id);
		if (item.isPresent()) {
			itemRepo.delete(item.get());
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
