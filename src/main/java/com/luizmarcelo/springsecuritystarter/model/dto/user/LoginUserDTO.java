package com.luizmarcelo.springsecuritystarter.model.dto.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LoginUserDTO {
    private String email;

    private String password;
}
