package ru.javamentor.SpringSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.SpringSecurity.models.Role;
import ru.javamentor.SpringSecurity.repositories.RoleRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return Optional.of(roleRepository.findAll())
                .orElseGet(Collections::emptyList);
    }
}
