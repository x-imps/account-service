package com.ximps.limit_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Payer implements Serializable {

    @NotNull
    private String customerId;

    @NotNull
    private String accountId;
}
