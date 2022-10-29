package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.model.User;
import com.epam.spring.homework3.model.enums.UserRole;
import com.epam.spring.homework3.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 20.10.2022
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    
    private final List<User> userList = new ArrayList<>();

    @PostConstruct
    public void initFirstUser() {
        User user = User.builder()
                .id(1)
                .email("example@mail.com")
                .login("ExampleLogin")
                .password("ExamplePassword123")
                .role(UserRole.STUDENT)
                .name("Name")
                .surname("Surname")
                .blocked(false)
                .build();
        userList.add(user);
    }

    @Override
    public User authenticationUser(String login, String password) {
        return userList.stream()
                .filter(u -> u.getLogin().equals(login) && u.getPassword().equals(password))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not fount"));
    }

    @Override
    public User addUser(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public User findUserByID(long userId) {
        return userList.stream()
                .filter(user -> user.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User is not found"));
    }

    @Override
    public User updateUser(long userId, User newUser) {
        boolean isRemoved = userList.removeIf(user -> user.getId() == userId);

        if (!isRemoved) {
            throw new RuntimeException("User is not found");
        }

        userList.add(newUser);
        return newUser;
    }

}
