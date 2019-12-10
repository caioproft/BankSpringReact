package com.invillia.bankSpringAndReact.model.response;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private String createdAt;
}
