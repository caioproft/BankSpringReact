package com.invillia.bankSpringAndReact.model.request;

import com.invillia.bankSpringAndReact.model.entity.User;
import com.invillia.bankSpringAndReact.model.enums.AccountType;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountRequest {

    @NotBlank
    private Double balance;

    @NotBlank
    private AccountType type;

    @NotBlank
    private User user;

}
