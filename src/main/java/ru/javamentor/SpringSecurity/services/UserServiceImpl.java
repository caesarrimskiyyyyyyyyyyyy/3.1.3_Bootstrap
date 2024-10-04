package ru.javamentor.SpringSecurity.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.SpringSecurity.models.User;
import ru.javamentor.SpringSecurity.repositories.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(username + " not found"));
    }

    @Override
    public List<User> getAllUsersWithRole() {
        return Optional.of(userRepository.findAllUsersWithRole())
                .orElseGet(Collections::emptyList);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User foundedUser = getUserByUsername(user.getUsername());

        if (foundedUser != null) {
            foundedUser.setUsername(user.getUsername());
            foundedUser.setEmail(user.getEmail());
            foundedUser.setBio(user.getBio());
            foundedUser.setRoles(user.getRoles());

            String newPassword = user.getPassword();
            if (newPassword != null && !foundedUser.getPassword().equals(newPassword)) {
                foundedUser.setPassword(passwordEncoder.encode(newPassword));
            }

            userRepository.save(foundedUser);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
