package com.invillia.bankSpringAndReact.model.response;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private String number;

    private String agency;

    private Double balance;

    private String createdAt;
}

