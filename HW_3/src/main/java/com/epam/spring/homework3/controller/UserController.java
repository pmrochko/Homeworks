package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.HistoryOfTestDTO;
import com.epam.spring.homework3.dto.UserDTO;
import com.epam.spring.homework3.service.HistoryOfTestService;
import com.epam.spring.homework3.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final HistoryOfTestService historyService;

    @GetMapping("/auth")
    public UserDTO authenticationUser(@RequestBody UserDTO form) {
        log.info("Authentication of the user account with login: {}", form.getLogin());
        return userService.authenticationUser(form);
    }

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        log.info("Creating a new user with email: {}", userDTO.getEmail());
        return userService.createUser(userDTO);
    }

    @GetMapping("/user")
    public List<UserDTO> getAllUsers() {
        log.info("Getting a list of all users");
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        log.info("Getting a user by id: {}", userId);
        return userService.getUserByID(userId);
    }

    @PutMapping("/user/{userId}")
    public UserDTO updateUser(@PathVariable Long userId, @RequestBody UserDTO userDTO) {
        log.info("Updating a user with id: {}", userId);
        return userService.updateUser(userId, userDTO);
    }

    @GetMapping("/user/{userId}/history")
    public List<HistoryOfTestDTO> getAllHistoryOfTests(@PathVariable Long userId) {
        log.info("Getting a list of all history of tests for the user with id: {}", userId);
        return historyService.getHistoryOfTests(userId);
    }

}
