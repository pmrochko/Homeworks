package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.UserDTO;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
public interface UserService {

    UserDTO authenticationUser(UserDTO userDTO);

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserByID(long id);

    UserDTO updateUser(long userId, UserDTO userDTO);

    List<UserDTO> getAllUsers();

}
