package pl.beda.UserAuthenticationSystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pl.beda.UserAuthenticationSystem.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByConfirmationToken(String token);
}
