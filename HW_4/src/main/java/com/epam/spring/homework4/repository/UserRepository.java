package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.User;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
public interface UserRepository {

    User authenticationUser(String login, String password);

    User addUser(User user);

    List<User> getAllUsers();

    User findUserByID(long userId);

    User updateUser(long userId, User newUser);

}
