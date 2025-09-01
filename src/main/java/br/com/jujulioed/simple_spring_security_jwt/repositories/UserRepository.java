package br.com.jujulioed.simple_spring_security_jwt.repositories;

import br.com.jujulioed.simple_spring_security_jwt.entities.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {

    //Id = username
    @Override
    Optional<User> findById(String username);

    @Query("INSERT INTO USERS (username, password) VALUES (:username, :password)")
    @Modifying
    void insert(@Param("username") String username, @Param("password") String password);
}
