package com.invillia.bankSpringAndReact.service.implementation;

import com.invillia.bankSpringAndReact.excepctions.IdNotFoundException;
import com.invillia.bankSpringAndReact.excepctions.InvalidValueException;
import com.invillia.bankSpringAndReact.mapper.AccountMapper;
import com.invillia.bankSpringAndReact.model.entity.Account;
import com.invillia.bankSpringAndReact.model.entity.User;
import com.invillia.bankSpringAndReact.model.request.DepositRequest;
import com.invillia.bankSpringAndReact.model.request.WithdrawRequest;
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

    @Transactional
    public void withdraw(WithdrawRequest withdrawRequest){
        if(withdrawRequest.getWithdrawValue() > 0){
            final Account account = accountRepository.findById(withdrawRequest.getIdAccount()).orElseThrow(() -> new IdNotFoundException("Conta não encontrada!"));

            if (account.getBalance() >= withdrawRequest.getWithdrawValue()){
                account.setBalance(account.getBalance() - withdrawRequest.getWithdrawValue());
                accountRepository.save(account);
            }
            else{
                throw new InvalidValueException("Você não possui saldo suficiente!");
            }
        }
        else {
            throw new InvalidValueException("O valor do saque não pode ser negativo!");
        }

    }

    @Transactional
    public void deposit (DepositRequest depositRequest){
        if (depositRequest.getDepositValue()> 0){
            final Account account = accountRepository.findById(depositRequest.getIdAccount()).orElseThrow(() -> new IdNotFoundException("Conta não encontrada"));

            account.setBalance(account.getBalance() + depositRequest.getDepositValue());
            accountRepository.save(account);
        }
        else{
            throw new InvalidValueException("Não é possível depositar um valor negativo!");
        }

    }
}
