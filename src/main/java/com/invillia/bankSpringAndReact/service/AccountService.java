package com.invillia.bankSpringAndReact.service;

import com.invillia.bankSpringAndReact.model.entity.Account;
import com.invillia.bankSpringAndReact.model.entity.User;
import com.invillia.bankSpringAndReact.model.request.DepositRequest;
import com.invillia.bankSpringAndReact.model.request.WithdrawRequest;
import com.invillia.bankSpringAndReact.model.response.AccountResponse;

import java.util.List;

public interface AccountService {

    List<AccountResponse> findAll();
    AccountResponse findById(final Long id);
    void create (final User user);
    void withdraw (WithdrawRequest withdrawRequest);
    void deposit (DepositRequest depositRequest);

}
