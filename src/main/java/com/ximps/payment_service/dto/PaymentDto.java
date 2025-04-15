package com.ximps.limit_service.dto;

import com.ximps.limit_service.constants.PaymentStatus;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PaymentDto implements Serializable {

    public String id;

    public String transactionId;

    public String payerCustomerId;

    public String payerAccountId;

    public String payeeBank;

    public String payeeIFSC;

    public String payeeAccountType;

    public String payeeAccountNumber;

    public Double amount;

    public String notes;

    public PaymentStatus status;

    public LocalDateTime createdOn;

    public PaymentDto() {
        this.id = UUID.randomUUID().toString();
    }
}