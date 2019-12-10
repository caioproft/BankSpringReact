package com.invillia.bankSpringAndReact.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;
}
