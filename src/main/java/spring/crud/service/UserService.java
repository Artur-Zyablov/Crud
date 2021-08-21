package spring.crud.service;

import spring.crud.model.User;

import java.util.List;

public interface UserService {
    List<User> readAllUsers();

    void createUser(User user);

    User deleteUser(Integer userId);

    User updateUser(User user);

    User readUser(Integer userId);
}
