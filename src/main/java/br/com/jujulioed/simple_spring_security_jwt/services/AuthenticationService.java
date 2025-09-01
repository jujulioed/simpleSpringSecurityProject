package br.com.jujulioed.simple_spring_security_jwt.services;

import br.com.jujulioed.simple_spring_security_jwt.dtos.UserRegisterRequestDTO;
import br.com.jujulioed.simple_spring_security_jwt.entities.User;
import br.com.jujulioed.simple_spring_security_jwt.repositories.UserRepository;
import br.com.jujulioed.simple_spring_security_jwt.security.JwtService;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthenticationService(JwtService jwtService, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public String authenticate(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }

    public void register(UserRegisterRequestDTO request) {
        if (userRepository.findById(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username já está em uso");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.insert(user.getUsername(), user.getPassword());
    }
}
