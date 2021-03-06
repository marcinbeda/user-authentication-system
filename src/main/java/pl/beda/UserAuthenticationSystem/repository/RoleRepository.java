package pl.beda.UserAuthenticationSystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pl.beda.UserAuthenticationSystem.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
