package ru.javamentor.SpringSecurity.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.javamentor.SpringSecurity.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    List<User> getAllUsers();

    Optional<User> getUserByUsername(String username);
}
