package com.invillia.bankSpringAndReact.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WithdrawRequest {

    @NotNull
    private Double withdrawValue;

    @NotNull
    private Long idAccount;
}
