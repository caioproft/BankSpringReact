package com.invillia.bankSpringAndReact.mapper;

import com.invillia.bankSpringAndReact.model.entity.Account;
import com.invillia.bankSpringAndReact.model.response.AccountResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    public AccountResponse accountToAccountResponse( Account account){
        return AccountResponse.builder()
                .id(account.getId())
                .nameUser(account.getUser().getName())
                .agency(account.getAgency())
                .number(account.getNumber())
                .balance(account.getBalance())
                .build();
    }

    public List<AccountResponse> accountToAccountResponse(List <Account> accounts){

        return accounts.stream()
                .map(this::accountToAccountResponse)
                .collect(Collectors.toList());
    }
}
