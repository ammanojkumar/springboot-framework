package io.mk.orm.repostory;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mk.orm.model.Item;

public interface ItemRepository extends JpaRepository<Item, String> {

}
