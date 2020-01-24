package com.invillia.bankSpringAndReact.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {

    @NotBlank(message = "O nome não pode estar em branco!")
    private String name;

    @NotBlank(message = "O e-mail não pode estar em branco!")
    private String email;
}
