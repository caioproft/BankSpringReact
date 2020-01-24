package com.invillia.bankSpringAndReact.service;

import com.invillia.bankSpringAndReact.model.request.UserSaveRequest;
import com.invillia.bankSpringAndReact.model.request.UserUpdateRequest;
import com.invillia.bankSpringAndReact.model.response.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> findAll();
    UserResponse findById(Long id);
    Long create (UserSaveRequest userSaveRequest);
    void update (Long id, UserUpdateRequest userUpdateRequest);
    void delete (Long id);
}
