package com.invillia.bankSpringAndReact.service;

import com.invillia.bankSpringAndReact.excepctions.IdNotFoundException;
import com.invillia.bankSpringAndReact.mapper.AccountMapper;
import com.invillia.bankSpringAndReact.model.entity.Account;
import com.invillia.bankSpringAndReact.model.request.AccountRequest;
import com.invillia.bankSpringAndReact.model.response.AccountResponse;
import com.invillia.bankSpringAndReact.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    private AccountRepository repository;
    private AccountMapper accountMapper;

    public AccountService(AccountRepository repository, AccountMapper accountMapper) {
        this.repository = repository;
        this.accountMapper = accountMapper;
    }

    @Transactional
    public Long create(AccountRequest accountRequest){
        Account account =  accountMapper.accountRequestToAccount(accountRequest);
        repository.save(account);
        return account.getId();
    }
    @Transactional
    public List<AccountResponse> findAll(){
        final List<Account> accounts =  repository.findAll();
        return accountMapper.accountToAccountReponse(accounts);
    }
    @Transactional
    public AccountResponse findById(final Long id){
        return repository.findById(id)
                .map(accountMapper::accountToAccountResponse)
                .orElseThrow(IdNotFoundException::new);
    }
    @Transactional
    public void update(final Long id, final AccountRequest accountRequest){
        final Account account =  repository.findById(id).orElseThrow(IdNotFoundException::new);
        accountMapper.updateAccountByAccountRequest(account, accountRequest);
        repository.save(account);
    }
    @Transactional
    public void delete(final Long id){
        final Account account = repository.findById(id).orElseThrow(IdNotFoundException::new);
        repository.delete(account);
    }
}
