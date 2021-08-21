package spring.crud.service;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.crud.dao.UserDAO;
import spring.crud.model.User;

import java.util.List;

@Service

public class UserServiceimpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceimpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> readAllUsers() {
        return userDAO.readAllUsers();
    }

    @Override
    @Transactional
    public void createUser(User user) {
       userDAO.createUser(user);
    }

    @Override
    @Transactional
    public User deleteUser(Integer userId) {
        try {
            userDAO.deleteUser(userId);
        } catch (InvalidDataAccessApiUsageException e) {
            System.out.println("Not found User");
        }
        return null;
    }

    @Override
    public User updateUser(User user) {
        return userDAO.updateUser(user);
    }

    @Override
    public User readUser(Integer userId) {
        return userDAO.readUser(userId);
    }
}
