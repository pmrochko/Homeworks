package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.UserDTO;
import com.epam.spring.homework4.mapper.UserMapper;
import com.epam.spring.homework4.model.User;
import com.epam.spring.homework4.model.enums.UserRole;
import com.epam.spring.homework4.repository.UserRepository;
import com.epam.spring.homework4.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO authenticationUser(UserDTO userDTO) {
        String login = userDTO.getLogin();
        String password = userDTO.getPassword();
        User user = userRepository.authenticationUser(login, password);
        log.info("User was authenticated successfully");
        return UserMapper.INSTANCE.mapToUserDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (!userDTO.getPassword().equals(userDTO.getRepeatPassword())) {
            log.warn("Incorrect entered password & repeat password");
            throw new RuntimeException("Incorrect entered data");
        } else {
            User user = UserMapper.INSTANCE.mapToUser(userDTO);
            user.setRole(UserRole.STUDENT);
            user.setBlocked(false);
            user = userRepository.addUser(user);
            log.info("New user was created successfully");
            return UserMapper.INSTANCE.mapToUserDTO(user);
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.getAllUsers();
        log.info("Successful getting a list of users from the repository");
        return UserMapper.INSTANCE.mapToListOfUsersDTO(userList);
    }

    @Override
    public UserDTO getUserByID(long userId) {
        User user = userRepository.findUserByID(userId);
        log.info("Successful getting a user from the repository");
        return UserMapper.INSTANCE.mapToUserDTO(user);
    }

    @Override
    public UserDTO updateUser(long userId, UserDTO userDTO) {
        User user = UserMapper.INSTANCE.mapToUser(userDTO);

        UserDTO oldUser = getUserByID(userDTO.getId());
        user.setEmail(oldUser.getEmail());
        user.setPassword(oldUser.getPassword());
        user.setTel(oldUser.getTel());

        user = userRepository.updateUser(userId, user);
        log.info("Successful updating a user in the repository");
        return UserMapper.INSTANCE.mapToUserDTO(user);
    }

}
