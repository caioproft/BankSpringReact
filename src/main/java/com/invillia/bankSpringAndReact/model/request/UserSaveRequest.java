package com.invillia.bankSpringAndReact.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveRequest {

    @NotBlank (message = "O nome não pode estar em branco!")
    private String name;

    @NotBlank (message = "O e-mail não pode estar em branco!")
    private String email;



}
