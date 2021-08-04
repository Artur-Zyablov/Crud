package spring.crud.dao;

import spring.crud.model.User;

import java.util.List;

public interface UserDAO {
    List<User> readAllUsers();

    User createUser(User user);

    User deleteUser(Integer userId);

    User updateUser(User user);

    User readUser(Integer userId);
}