package com.invillia.bankSpringAndReact.mapper;

import com.invillia.bankSpringAndReact.model.entity.Account;
import com.invillia.bankSpringAndReact.model.request.AccountRequest;
import com.invillia.bankSpringAndReact.model.response.AccountResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {

    public AccountResponse accountToAccountResponse(final Account account){
        AccountResponse accountResponse = new AccountResponse();

        accountResponse.setId(account.getId());
        accountResponse.setBalance(account.getBalance());
        accountResponse.setType(account.getAccountType());
        accountResponse.setUser(account.getUser());
        return accountResponse;
    }

    public List<AccountResponse> accountToAccountReponse(final List<Account> accounts){
        return accounts.stream()
                .map(this::accountToAccountResponse)
                .collect(Collectors.toList());
    }

    public Account accountRequestToAccount(final AccountRequest accountRequest){
        final Account account = new Account();
        account.setBalance(accountRequest.getBalance());
        account.setAccountType(accountRequest.getType());
        account.setUser(accountRequest.getUser());

        return account;
    }

    public void updateAccountByAccountRequest(final Account account, final AccountRequest accountRequest){
        account.setBalance(accountRequest.getBalance());
        account.setAccountType(accountRequest.getType());
        account.setUser(accountRequest.getUser());
    }
}
