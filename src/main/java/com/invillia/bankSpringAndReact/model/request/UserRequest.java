package com.invillia.bankSpringAndReact.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String number;

    @NotBlank
    private String agency;

    @NotNull
    private Double balance;

}
