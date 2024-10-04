package ru.javamentor.SpringSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.javamentor.SpringSecurity.dto.UserDetailsImpl;
import ru.javamentor.SpringSecurity.models.User;
import ru.javamentor.SpringSecurity.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundedUser = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));

        return new UserDetailsImpl(foundedUser);
    }
}
