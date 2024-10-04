package ru.javamentor.SpringSecurity.services;

import ru.javamentor.SpringSecurity.models.User;

import java.util.List;

public interface UserService {
    User getUserByUsername(String username);

    List<User> getAllUsersWithRole();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
