package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.User;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
public interface UserRepository {

    User authenticationUser(String login, String password);

    User addUser(User user);

    List<User> getAllUsers();

    User findUserByID(long userId);

    User updateUser(long userId, User newUser);

}
