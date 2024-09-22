package ru.javamentor.SpringSecurity.dao;

import ru.javamentor.SpringSecurity.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
}
