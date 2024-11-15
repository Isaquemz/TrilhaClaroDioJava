package edu.isaque.todotool.controller;

import edu.isaque.todotool.dto.auth.LoginUserRequestDTO;
import edu.isaque.todotool.dto.auth.LoginUserResponseDTO;
import edu.isaque.todotool.dto.auth.RegisterUserRequestDTO;
import edu.isaque.todotool.dto.auth.RegisterUserResponseDTO;
import edu.isaque.todotool.model.CustomUserDetails;
import edu.isaque.todotool.service.auth.AuthenticationService;
import edu.isaque.todotool.service.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RoleNotFoundException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponseDTO> register(@Validated @RequestBody RegisterUserRequestDTO dto)
            throws RoleNotFoundException {

        Long id = authenticationService.signup(dto);

        RegisterUserResponseDTO response = new RegisterUserResponseDTO();
        response.setId(id);

        return ResponseEntity.created(null).body(response);

    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponseDTO> authenticate(@Validated @RequestBody LoginUserRequestDTO dto) {

        CustomUserDetails authenticatedUser = authenticationService.authenticate(dto);
        String token = jwtService.generateToken(authenticatedUser);

        LoginUserResponseDTO response = LoginUserResponseDTO.builder()
                .token(token)
                .expiresIn(jwtService.getExpirationTime())
                .build();

        return ResponseEntity.ok(response);

    }

}
