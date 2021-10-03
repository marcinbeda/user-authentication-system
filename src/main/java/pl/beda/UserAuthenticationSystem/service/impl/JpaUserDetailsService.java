package pl.beda.UserAuthenticationSystem.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pl.beda.UserAuthenticationSystem.entity.User;
import pl.beda.UserAuthenticationSystem.repository.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> usernameOptional = userRepository.findByUsername(username);
        if (!usernameOptional.isPresent()) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
        User user = usernameOptional.get();
        return user;
    }
}
