package ru.javamentor.SpringSecurity.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.javamentor.SpringSecurity.models.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
