package com.invillia.bankSpringAndReact.model.response;

import com.invillia.bankSpringAndReact.model.entity.User;
import com.invillia.bankSpringAndReact.model.enums.AccountType;
import lombok.Data;

@Data
public class AccountResponse {

    private Long id;

    private Double balance;

    private AccountType type;

    private User user;

}
