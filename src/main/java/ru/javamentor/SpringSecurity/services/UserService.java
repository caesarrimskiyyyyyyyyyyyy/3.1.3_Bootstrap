package ru.javamentor.SpringSecurity.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.javamentor.SpringSecurity.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDetails loadUserByUsername(String username);

    User getUserByUsername(String username);

    List<User> getAllUsersWithRole();

    void saveUser(User user);

    void deleteUser(Long id);
}
