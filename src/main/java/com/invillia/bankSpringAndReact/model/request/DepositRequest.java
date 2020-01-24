package com.invillia.bankSpringAndReact.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DepositRequest {

    @NotNull
    private Double depositValue;

    @NotNull
    private Long idAccount;
}
