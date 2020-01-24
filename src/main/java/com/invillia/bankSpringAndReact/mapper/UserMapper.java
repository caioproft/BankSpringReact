package com.invillia.bankSpringAndReact.mapper;

import com.invillia.bankSpringAndReact.model.entity.User;
import com.invillia.bankSpringAndReact.model.request.UserSaveRequest;
import com.invillia.bankSpringAndReact.model.request.UserUpdateRequest;
import com.invillia.bankSpringAndReact.model.response.UserResponse;
import org.springframework.stereotype.Component;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserResponse userToUserResponse(User user){

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public List<UserResponse> userToUserResponse(List <User> users){
        return users.stream()
                .map(this::userToUserResponse)
                .collect((Collectors.toList()));
    }

    public User userSaveRequestToUser(UserSaveRequest userSaveRequest){
        User user = new User();

        user.setName(userSaveRequest.getName());
        user.setEmail(userSaveRequest.getEmail());

        return user;
    }

    public void userUpdateRequestToUser (User user, UserUpdateRequest userUpdateRequest){

        user.setName(userUpdateRequest.getName());
        user.setEmail(userUpdateRequest.getEmail());
    }
}
