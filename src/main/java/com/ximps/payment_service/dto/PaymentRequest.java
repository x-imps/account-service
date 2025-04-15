package com.ximps.limit_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PaymentRequest implements Serializable {

    @NotNull
    @Valid
    private Payer payer;

    @NotNull
    @Valid
    private Payee payee;

    @NotNull
    @Positive(message = "amount must be positive")
    private Double amount;

    private String note;
}
