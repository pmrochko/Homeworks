package com.epam.spring.homework3.mapper;

import com.epam.spring.homework3.dto.UserDTO;
import com.epam.spring.homework3.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 21.10.2022
 */
@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", expression = "java(null)")
    UserDTO mapToUserDTO(User user);

    User mapToUser(UserDTO userDTO);

    List<UserDTO> mapToListOfUsersDTO(List<User> userList);

}
