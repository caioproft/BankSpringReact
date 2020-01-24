package com.invillia.bankSpringAndReact.controller;

import com.invillia.bankSpringAndReact.model.request.UserSaveRequest;
import com.invillia.bankSpringAndReact.model.request.UserUpdateRequest;
import com.invillia.bankSpringAndReact.model.response.UserResponse;
import com.invillia.bankSpringAndReact.service.implementation.UserServiceImplementation;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController{

    private final UserServiceImplementation userService;

    public UserController(UserServiceImplementation userService) {
        this.userService = userService;
    }

    @PostMapping
    public HttpEntity<?> save (@RequestBody final UserSaveRequest userSaveRequest){
        Long idUser = userService.create(userSaveRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/users/{id}")
                .build(idUser);

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
    public HttpEntity<?> update(@PathVariable final Long id,  @RequestBody @Valid UserUpdateRequest userUpdateRequest){
       userService.update(id, userUpdateRequest);

       return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete (@PathVariable final Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}