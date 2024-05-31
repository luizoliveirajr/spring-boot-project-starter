package com.luizmarcelo.springsecuritystarter.model.dto.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RegisterUserDTO {
    private String email;

    private String password;

    private String fullName;
}
