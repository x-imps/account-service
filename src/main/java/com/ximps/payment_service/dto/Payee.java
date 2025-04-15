package com.ximps.limit_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Payee implements Serializable {

    private String bankName;

    @NotNull
    private String ifsc;

    @NotNull
    private String accountNumber;

    @NotNull
    private String accountType;
}
