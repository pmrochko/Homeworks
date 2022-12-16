package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.UserDTO;
import com.epam.spring.homework4.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO mapToUserDTO(User user);

    User mapToUser(UserDTO userDTO);

    List<UserDTO> mapToListOfUsersDTO(List<User> userList);

}
