package br.com.jujulioed.simple_spring_security_jwt.repositories;

import br.com.jujulioed.simple_spring_security_jwt.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRespository extends CrudRepository<User, String> {

    //Id = username
    @Override
    Optional<User> findById(String username);
}
