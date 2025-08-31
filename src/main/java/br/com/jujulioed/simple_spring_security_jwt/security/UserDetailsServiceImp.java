package br.com.jujulioed.simple_spring_security_jwt.security;

import br.com.jujulioed.simple_spring_security_jwt.repositories.UserRespository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRespository userRespository;

    public UserDetailsServiceImp(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRespository.findById(username)
                .map(UserAuthenticated::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
