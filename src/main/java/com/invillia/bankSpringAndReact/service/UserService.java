//package com.invillia.bankSpringAndReact.service;
//
//import com.invillia.bankSpringAndReact.excepctions.IdNotFoundException;
//import com.invillia.bankSpringAndReact.mapper.UserMapper;
//import com.invillia.bankSpringAndReact.model.entity.User;
//import com.invillia.bankSpringAndReact.model.request.UserSaveRequest;
//import com.invillia.bankSpringAndReact.model.response.UserResponse;
//import com.invillia.bankSpringAndReact.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//public class UserService {
//
//    private UserRepository userRepository;
//
//    private UserMapper userMapper;
//
//    public UserService(UserRepository userRepository, UserMapper userMapper) {
//        this.userRepository = userRepository;
//        this.userMapper = userMapper;
//    }
//
//
//    @Transactional
//    public Long createUser(UserSaveRequest userSaveRequest){
//
//        User user = userMapper.userRequestToUser(userSaveRequest);
//        userRepository.save(user);
//
//        return user.getId();
//    }
//    @Transactional
//    public List <UserResponse> findAll(){
//
//        List <User> users = userRepository.findAll();
//
//        return userMapper.userToUserResponse(users);
//    }
//    @Transactional
//    public UserResponse findById(Long id){
//
//        return userRepository.findById(id)
//                .map(userMapper::userToUserResponse)
//                .orElseThrow(IdNotFoundException::new);
//    }
//    @Transactional
//    public void update(Long id, UserSaveRequest userSaveRequest){
//        User user = userRepository.findById(id)
//                .orElseThrow(IdNotFoundException::new);
//        userMapper.updateUserByUserRequest(user, userSaveRequest);
//        userRepository.save(user);
//    }
//
//    @Transactional
//    public void delete(Long id){
//        User user = userRepository.findById(id)
//                .orElseThrow(IdNotFoundException::new);
//        userRepository.delete(user);
//    }

//    @Transactional
//    public void withdraw(Long id, double value){
//        User user = userRepository.findById(id).orElseThrow(IdNotFoundException::new);
//        if (value >= 0.0 && value <= user.getBalance() ){
//            user.setBalance(user.getBalance() - value);
//            userRepository.save(user);
//        }
//        else{
//            throw  new InvalidValueException();
//        }
//    }
//
//    @Transactional
//    public void deposit(Long id, double value){
//        User user = userRepository.findById(id).orElseThrow(IdNotFoundException::new);
//        if (value >= 0) {
//            user.setBalance(user.getBalance() + value);
//        }
//        else{
//            throw new InvalidValueException();
//        }
//    }
//}
