package io.mk.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mk.pos.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
