package com.invillia.bankSpringAndReact.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

    @NotNull
    private Long id;

    @NotBlank
    private Long userId;

    @NotBlank
    private String number;

    @NotBlank
    private String agency;

    @NotNull
    private Double balance;
}
