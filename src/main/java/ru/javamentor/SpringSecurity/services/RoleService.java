package ru.javamentor.SpringSecurity.services;

import ru.javamentor.SpringSecurity.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
}
