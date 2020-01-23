package com.invillia.bankSpringAndReact.controller;


import com.invillia.bankSpringAndReact.model.request.DepositRequest;
import com.invillia.bankSpringAndReact.model.request.UserRequest;
import com.invillia.bankSpringAndReact.model.request.WithdrawRequest;
import com.invillia.bankSpringAndReact.model.response.UserResponse;
import com.invillia.bankSpringAndReact.service.UserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public HttpEntity<?> create(@Valid @RequestBody final UserRequest userRequest){
        final Long id = userService.createUser(userRequest);
        final URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{id}").build(id);
        return ResponseEntity.created(location).build();
    }
    @GetMapping
    public List<UserResponse> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable final Long id){
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable final Long id,
                                @Valid @RequestBody final UserRequest userRequest){
        userService.update(id, userRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable final Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @PutMapping("/{id}/withdraw")
//    public HttpEntity<?> withdraw(@PathVariable Long id, @RequestBody WithdrawRequest withdrawRequest){
//        userService.withdraw(id, withdrawRequest.getWithdrawValue());
//        return ResponseEntity.accepted().build();
//    }
//
//    @PutMapping("/{id}/deposit")
//    public HttpEntity<?> deposit(@PathVariable Long id, @RequestBody DepositRequest depositRequest){
//        userService.deposit(id, depositRequest.getDepositValue());
//        return ResponseEntity.accepted().build();
//    }
}
