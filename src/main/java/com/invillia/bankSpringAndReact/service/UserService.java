package com.invillia.bankSpringAndReact.service;

import com.invillia.bankSpringAndReact.excepctions.IdNotFoundException;
import com.invillia.bankSpringAndReact.mapper.UserMapper;
import com.invillia.bankSpringAndReact.model.entity.User;
import com.invillia.bankSpringAndReact.model.request.UserRequest;
import com.invillia.bankSpringAndReact.model.response.UserResponse;
import com.invillia.bankSpringAndReact.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Transactional
    public Long createUser(UserRequest userRequest){

        User user = userMapper.userRequestToUser(userRequest);
        userRepository.save(user);

        return user.getId();
    }
    @Transactional
    public List <UserResponse> findAll(){

        List <User> users = userRepository.findAll();

        return userMapper.userToUserResponse(users);
    }
    @Transactional
    public UserResponse findById(Long id){

        return userRepository.findById(id)
                .map(userMapper::userToUserResponse)
                .orElseThrow(IdNotFoundException::new);
    }
    @Transactional
    public void update(Long id, UserRequest userRequest){
        User user = userRepository.findById(id)
                .orElseThrow(IdNotFoundException::new);
        userMapper.updateUserByUserRequest(user, userRequest);
        userRepository.save(user);
    }

    @Transactional
    public void delete(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(IdNotFoundException::new);
        userRepository.delete(user);
    }
}
