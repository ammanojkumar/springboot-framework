package io.mk.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mk.pos.entity.TransactionInfo;

public interface TransactionRepository extends JpaRepository<TransactionInfo, String> {

}
