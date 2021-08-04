package spring.crud.service;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
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
    public User createUser(User user) {
        return userDAO.createUser(user);
    }

    @Override
    public User deleteUser(Integer userId) {
        try {
            return userDAO.deleteUser(userId);
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
