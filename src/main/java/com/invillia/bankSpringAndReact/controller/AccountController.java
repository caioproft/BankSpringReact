package com.invillia.bankSpringAndReact.controller;

import com.invillia.bankSpringAndReact.model.request.DepositRequest;
import com.invillia.bankSpringAndReact.model.request.WithdrawRequest;
import com.invillia.bankSpringAndReact.model.response.AccountResponse;
import com.invillia.bankSpringAndReact.service.AccountService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public AccountResponse findById(@PathVariable final Long id){
        return accountService.findById(id);
    }

    @PostMapping("/withdraw")
    public HttpEntity<?> withdraw(@Valid @RequestBody final WithdrawRequest withdrawRequest){
        accountService.withdraw(withdrawRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/deposit")
    public HttpEntity<?> deposit(@Valid @RequestBody DepositRequest depositRequest){
        accountService.deposit(depositRequest);
        return ResponseEntity.ok().build();
    }
}
