package com.luizmarcelo.springsecuritystarter.service.authentication;

import com.luizmarcelo.springsecuritystarter.model.dto.user.LoginResponseDTO;
import com.luizmarcelo.springsecuritystarter.model.dto.user.LoginUserDTO;
import com.luizmarcelo.springsecuritystarter.model.dto.user.RegisterUserDTO;
import com.luizmarcelo.springsecuritystarter.model.user.User;
import com.luizmarcelo.springsecuritystarter.security.service.JwtService;
import com.luizmarcelo.springsecuritystarter.service.user.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationService(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }


    public User signup(RegisterUserDTO input) {
        User user = User.builder()
                .fullName(input.getFullName())
                .email(input.getEmail())
                .password(this.bCryptPasswordEncoder.encode(input.getPassword()))
                .build();

        return userService.save(user);
    }

    public User authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userService.findByEmail(input.getEmail())
                .orElseThrow();
    }

    public LoginResponseDTO login(LoginUserDTO loginUserDto){
        User authenticatedUser = authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);
        String refreshToken = jwtService.generateRefreshToken(authenticatedUser);
        LoginResponseDTO loginResponse = LoginResponseDTO.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .refreshToken(refreshToken)
                .build();
        return loginResponse;
    }

}
