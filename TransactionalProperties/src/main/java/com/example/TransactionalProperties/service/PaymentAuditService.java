package com.example.TransactionalProperties.service;

import com.example.TransactionalProperties.entity.Order;
import com.example.TransactionalProperties.entity.PaymentAudit;
import com.example.TransactionalProperties.repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {
    private PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository) {
        this.paymentAuditRepository = paymentAuditRepository;
    }

    @Transactional(
            propagation = Propagation.MANDATORY
    )
    public void audit(Order order){
        PaymentAudit paymentAudit=new PaymentAudit(order.getAmount(),order.getId(),true);
        paymentAuditRepository.save(paymentAudit);
//        throw new RuntimeException("Something went wrong");
    }
}
