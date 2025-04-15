package com.ximps.limit_service.dto;

import com.ximps.limit_service.constants.PaymentStatus;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse implements Serializable {
    public String paymentId;
    public String transactionId;
    public PaymentStatus paymentStatus;
}
