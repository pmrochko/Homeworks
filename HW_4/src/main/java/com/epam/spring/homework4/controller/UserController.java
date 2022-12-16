package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.HistoryOfTestDTO;
import com.epam.spring.homework4.dto.UserDTO;
import com.epam.spring.homework4.dto.group.OnCreate;
import com.epam.spring.homework4.dto.group.OnUpdate;
import com.epam.spring.homework4.service.HistoryOfTestService;
import com.epam.spring.homework4.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @author Pavlo Mrochko
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
    public UserDTO createUser(@RequestBody @Validated(OnCreate.class) UserDTO userDTO) {
        log.info("Creating a new user with email: {}", userDTO.getEmail());
        return userService.createUser(userDTO);
    }

    @GetMapping("/user")
    public List<UserDTO> getAllUsers() {
        log.info("Getting a list of all users");
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public UserDTO getUserById(@PathVariable @Positive Long userId) {
        log.info("Getting a user by id: {}", userId);
        return userService.getUserByID(userId);
    }

    @PutMapping("/user/{userId}")
    public UserDTO updateUser(@PathVariable @Positive Long userId,
                              @RequestBody @Validated(OnUpdate.class) UserDTO userDTO) {
        log.info("Updating a user with id: {}", userId);
        return userService.updateUser(userId, userDTO);
    }

    @GetMapping("/user/{userId}/history")
    public List<HistoryOfTestDTO> getAllHistoryOfTests(@PathVariable @Positive Long userId) {
        log.info("Getting a list of all history of tests for the user with id: {}", userId);
        return historyService.getHistoryOfTests(userId);
    }

}
