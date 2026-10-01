package com.example.TransactionalProperties.repository;

import com.example.TransactionalProperties.entity.Order;
import com.example.TransactionalProperties.entity.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAuditRepository extends JpaRepository<PaymentAudit,Long> {

}
