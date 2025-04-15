package com.ximps.limit_service.service;

import com.ximps.common.service.AbstractService;
import com.ximps.limit_service.constants.PaymentStatus;
import com.ximps.limit_service.entity.Payment;
import com.ximps.limit_service.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Transactional
@Slf4j
public class PaymentService extends AbstractService<Payment, String, PaymentRepository> {

    public Payment processPayment(Payment payment) {

        String transactionId = UUID.randomUUID().toString();
        payment.setTransactionId(transactionId);

        payment.setStatus(PaymentStatus.SUCCESS);

        this.save(payment);

        return payment;
    }
}
