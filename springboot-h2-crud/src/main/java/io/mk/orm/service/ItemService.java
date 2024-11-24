package io.mk.orm.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mk.orm.exception.ItemAlreadyExistsException;
import io.mk.orm.exception.ItemNotFoundException;
import io.mk.orm.model.Item;
import io.mk.orm.repostory.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepo;

	public Item saveItem(Item item) {
		Optional<Item> dbItemOpt = itemRepo.findById(item.getItemId());
		if (dbItemOpt.isPresent()) {
			throw new ItemAlreadyExistsException();
		}
		return itemRepo.save(item);
	}

	public Item updateItem(Item item) {
		Optional<Item> dbItemOpt = itemRepo.findById(item.getItemId());
		if (!dbItemOpt.isPresent()) {
			throw new ItemNotFoundException();
		}
		Item dbItem = dbItemOpt.get();
		if (Objects.nonNull(item.getName())) {
			dbItem.setName(item.getName());
		}
		if (Objects.nonNull(item.getPrice())) {
			dbItem.setPrice(item.getPrice());
		}
		return itemRepo.save(dbItem);
	}

	public Item getItem(Integer id) {
		Optional<Item> item = itemRepo.findById(id);

		if (item.isPresent()) {
			return item.get();
		}
		throw new ItemNotFoundException();
	}

	public List<Item> getAllItems() {
		return itemRepo.findAll();
	}

	public void deleteItem(Integer id) {
		Optional<Item> item = itemRepo.findById(id);
		if (item.isPresent()) {
			itemRepo.delete(item.get());
		} else {
			throw new ItemNotFoundException();
		}
	}
}
