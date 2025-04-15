package com.ximps.limit_service.controller;

import com.ximps.limit_service.dto.PaymentDto;
import com.ximps.limit_service.dto.PaymentRequest;
import com.ximps.limit_service.dto.PaymentResponse;
import com.ximps.limit_service.entity.Payment;
import com.ximps.limit_service.mapper.PaymentMapper;
import com.ximps.limit_service.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentMapper paymentMapper;

    @GetMapping("/{paymentId}")
    public PaymentDto findById(@PathVariable String paymentId) {
        Payment payment = paymentService.find(paymentId);
        return paymentMapper.entityToDto(payment);
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> startPayment(@RequestBody @Valid PaymentRequest paymentRequest) {

        Payment payment = Payment.builder()
                .id(UUID.randomUUID().toString())
                .amount(paymentRequest.getAmount())
                .payerCustomerId(paymentRequest.getPayer().getCustomerId())
                .payerAccountId(paymentRequest.getPayer().getAccountId())
                .payeeBank(paymentRequest.getPayee().getBankName())
                .payeeIfsc(paymentRequest.getPayee().getIfsc())
                .payeeAccountNumber(paymentRequest.getPayee().getAccountNumber())
                .payeeAccountType(paymentRequest.getPayee().getAccountType())
                .notes(paymentRequest.getNote())
                .build();

        payment = paymentService.processPayment(payment);

        PaymentResponse paymentResponse = PaymentResponse.builder().paymentId(payment.getId())
                .transactionId(payment.getTransactionId())
                .paymentStatus(payment.getStatus()).build();

        return  ResponseEntity.ok(paymentResponse);
    }

}
