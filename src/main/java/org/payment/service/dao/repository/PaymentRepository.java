package org.payment.service.dao.repository;

import org.payment.service.dao.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {
    boolean existsByAccountNumber(String accountNumber);
    Optional<PaymentEntity> findByAccountNumber(String accountNumber);
}
