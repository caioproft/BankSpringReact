package com.invillia.bankSpringAndReact.mapper;

import com.invillia.bankSpringAndReact.model.entity.User;
import com.invillia.bankSpringAndReact.model.request.UserSaveRequest;
import com.invillia.bankSpringAndReact.model.response.UserResponse;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public UserResponse userToUserResponse(User user){

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }

    public List<UserResponse> userToUserResponse(List <User> users){
        return users.stream()
                .map(this::userToUserResponse)
                .collect((Collectors.toList()));
    }

    public User userRequestToUser(UserSaveRequest userSaveRequest){

        User user = new User();

        user.setName(userSaveRequest.getName());
        user.setEmail(userSaveRequest.getEmail());

        return user;
    }

    public void updateUserByUserRequest(User user, UserSaveRequest userSaveRequest){

        user.setName(userSaveRequest.getName());
        user.setEmail(userSaveRequest.getEmail());
    }
}
