package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.UserDTO;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
public interface UserService {

    UserDTO authenticationUser(UserDTO userDTO);

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserByID(long id);

    UserDTO updateUser(long userId, UserDTO userDTO);

    List<UserDTO> getAllUsers();

}
