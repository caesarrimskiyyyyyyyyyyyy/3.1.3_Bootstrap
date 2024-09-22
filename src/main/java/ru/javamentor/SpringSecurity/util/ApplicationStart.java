package ru.javamentor.SpringSecurity.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.SpringSecurity.models.User;

@Component
@Transactional
public class ApplicationStart implements ApplicationRunner {
    @PersistenceContext
    private EntityManager entityManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationStart(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) {
        User user = new User();
        user.setUsername("user");
        user.setEmail("user@email.com");
        user.setBio("i am user bio");
        user.setPassword(passwordEncoder.encode("user"));
        entityManager.persist(user);
    }
}
