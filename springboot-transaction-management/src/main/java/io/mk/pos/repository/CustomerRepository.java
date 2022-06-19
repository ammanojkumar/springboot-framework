package io.mk.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mk.pos.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
