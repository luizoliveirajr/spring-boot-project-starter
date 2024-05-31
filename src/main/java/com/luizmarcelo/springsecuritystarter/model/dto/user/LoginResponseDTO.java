package com.luizmarcelo.springsecuritystarter.model.dto.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LoginResponseDTO {
    private String token;
    private long expiresIn;
    private String refreshToken;
}
