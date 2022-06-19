package io.mk.pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mk.pos.entity.PaymentInfo;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {

}