package com.invillia.bankSpringAndReact.service.implementation;

import com.invillia.bankSpringAndReact.excepctions.IdNotFoundException;
import com.invillia.bankSpringAndReact.mapper.AccountMapper;
import com.invillia.bankSpringAndReact.model.entity.Account;
import com.invillia.bankSpringAndReact.model.entity.User;
import com.invillia.bankSpringAndReact.model.response.AccountResponse;
import com.invillia.bankSpringAndReact.repository.AccountRepository;
import com.invillia.bankSpringAndReact.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImplementation implements AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    public AccountServiceImplementation(AccountMapper accountMapper, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public List<AccountResponse> findAll(){
        final List<Account> accounts = accountRepository.findAll();
        return accountMapper.accountToAccountResponse(accounts);
    }

    public AccountResponse findById(Long id){
        return accountRepository.findById(id).map(accountMapper::accountToAccountResponse).orElseThrow(() -> new IdNotFoundException("Conta não encontrada!"));
    }

    @Transactional
    public void create(User user){

        Account account = new Account(user);
        accountRepository.save(account);
    }
}
