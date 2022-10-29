package com.epam.spring.homework3.model;

import com.epam.spring.homework3.model.enums.UserRole;
import lombok.Builder;
import lombok.Data;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
@Data
@Builder
public class User {

    private long id;
    private String login;
    private String email;
    private UserRole role;
    private String password;
    private String name;
    private String surname;
    private String tel;
    private boolean blocked;

}
