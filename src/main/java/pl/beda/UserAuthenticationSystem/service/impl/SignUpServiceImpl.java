package pl.beda.UserAuthenticationSystem.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import pl.beda.UserAuthenticationSystem.component.mailer.RandomStringFactory;
import pl.beda.UserAuthenticationSystem.component.mailer.SingUpMailer;
import pl.beda.UserAuthenticationSystem.entity.Role;
import pl.beda.UserAuthenticationSystem.entity.User;
import pl.beda.UserAuthenticationSystem.repository.RoleRepository;
import pl.beda.UserAuthenticationSystem.repository.UserRepository;
import pl.beda.UserAuthenticationSystem.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {

    private static final int TOKEN_LENGTH = 15;

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private SingUpMailer mailer;

    private RoleRepository roleRepository;

    @Autowired
    public SignUpServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, SingUpMailer mailer,
                             RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailer = mailer;
        this.roleRepository = roleRepository;
    }

    @Override
    public User signUpUser(User user) {
        Assert.isNull(user.getIdUser(), "Can't sign up given user, it already has set id. User: " + user.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        String token = RandomStringFactory.getRandomString(TOKEN_LENGTH);
        user.setConfirmationToken(token);
        Optional<Role> roleOptional = roleRepository.findByName("USER");
        if (roleOptional.isPresent()) {
            user.getRoles().add(roleOptional.get());
        }
        mailer.sendConfirmationLink(user.getEmail(), token);
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
