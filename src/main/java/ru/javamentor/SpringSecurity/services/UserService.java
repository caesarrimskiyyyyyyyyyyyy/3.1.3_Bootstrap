package ru.javamentor.SpringSecurity.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.javamentor.SpringSecurity.models.User;

public interface UserService extends UserDetailsService {
    UserDetails loadUserByUsername(String username);

    User findUserByUsername(String username);
}
