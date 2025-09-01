package br.com.jujulioed.simple_spring_security_jwt.controllers;

import br.com.jujulioed.simple_spring_security_jwt.dtos.UserRegisterRequestDTO;
import br.com.jujulioed.simple_spring_security_jwt.entities.User;
import br.com.jujulioed.simple_spring_security_jwt.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("authenticate")
    public String authenticate(Authentication authentication) {
        return authenticationService.authenticate(authentication);
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequestDTO request) {
        authenticationService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso.");
    }

    @GetMapping("test")
    public String test() {
        return "Test API";
    }
}
