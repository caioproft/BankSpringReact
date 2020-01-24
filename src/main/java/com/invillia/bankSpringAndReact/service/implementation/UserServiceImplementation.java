package com.invillia.bankSpringAndReact.service.implementation;

import com.invillia.bankSpringAndReact.excepctions.IdNotFoundException;
import com.invillia.bankSpringAndReact.mapper.UserMapper;
import com.invillia.bankSpringAndReact.model.entity.User;
import com.invillia.bankSpringAndReact.model.request.UserSaveRequest;
import com.invillia.bankSpringAndReact.model.request.UserUpdateRequest;
import com.invillia.bankSpringAndReact.model.response.UserResponse;
import com.invillia.bankSpringAndReact.repository.UserRepository;
import com.invillia.bankSpringAndReact.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AccountServiceImplementation accountService;

    public UserServiceImplementation(UserRepository userRepository, UserMapper userMapper, AccountServiceImplementation accountService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.accountService = accountService;
    }


    @Transactional
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public UserResponse findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::userToUserResponse)
                .orElseThrow(() -> new IdNotFoundException("Usuário não encontrado!"));
    }

    @Transactional
    public Long create(UserSaveRequest userSaveRequest) {

        User user = userMapper.userSaveRequestToUser(userSaveRequest);
        userRepository.save(user);
        accountService.create(user);

        return user.getId();
    }

    @Transactional
    public void update(Long id, UserUpdateRequest userUpdateRequest) {

         User user = userRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Usuário não encontrado."));

         userMapper.userUpdateRequestToUser(user, userUpdateRequest);

         userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Usuário inexistente"));

        userRepository.delete(user);
    }
}
