package com.luizmarcelo.springsecuritystarter.controller.authentication;

import com.luizmarcelo.springsecuritystarter.model.dto.user.LoginResponseDTO;
import com.luizmarcelo.springsecuritystarter.model.dto.user.LoginUserDTO;
import com.luizmarcelo.springsecuritystarter.model.dto.user.RegisterUserDTO;
import com.luizmarcelo.springsecuritystarter.model.user.User;
import com.luizmarcelo.springsecuritystarter.service.authentication.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@Tag(name = "Autenticação", description = "cadastro e autenticação de usuarios")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Operation(
            summary = "Registra um novo usuario",
            description = "Registre um usuario usando os campos nome completo, email e senha"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = User.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDTO registerUserDto) {
        return ResponseEntity.ok(authenticationService.signup(registerUserDto));
    }

    @Operation(
            summary = "Autentica o usuario",
            description = "Autentique o usuario pelo email e senha"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = LoginResponseDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody LoginUserDTO loginUserDto) {
        return ResponseEntity.ok(authenticationService.login(loginUserDto));
    }

}
