package com.finnotek.assignment.security;


import com.finnotek.assignment.domain.User;
import com.finnotek.assignment.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationUtils {

    private final UserRepository userRepository;

    public AuthenticationUtils(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getAuthenticatedUser() {
        var username = SecurityUtils.getCurrentUserLogin();
        if (username.isEmpty()) {
            return Optional.empty();
        }

        return userRepository.findOneByLogin(username.get());

    }

}
