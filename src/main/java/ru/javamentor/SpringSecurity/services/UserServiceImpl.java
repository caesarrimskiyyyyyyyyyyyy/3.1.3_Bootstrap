package ru.javamentor.SpringSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.SpringSecurity.dao.UserDAO;
import ru.javamentor.SpringSecurity.models.User;
import ru.javamentor.SpringSecurity.security.MyUserDetails;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> foundedUser = getUserByUsername(username);
        if (foundedUser.isEmpty()) {
            throw new UsernameNotFoundException(username + " not found");
        }

        return new MyUserDetails(foundedUser.get());
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        List<User> userList = getAllUsers();
        return userList.stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny();
    }
}
