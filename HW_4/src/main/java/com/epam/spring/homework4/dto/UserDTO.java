package com.epam.spring.homework4.dto;

import com.epam.spring.homework4.dto.group.OnCreate;
import com.epam.spring.homework4.dto.group.OnUpdate;
import com.epam.spring.homework4.model.enums.UserRole;
import com.epam.spring.homework4.validation.ValidPassword;
import com.epam.spring.homework4.validation.ValueOfEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author Pavlo Mrochko
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    /* For change email, tel, password
    must be implemented other service.
    So, in the request email, tel, password fields must be null */

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Positive
    private long id;

    @NotBlank(message = "'login' shouldn't be absent in the request", groups = {OnCreate.class, OnUpdate.class})
    private String login;

    @Email(message = "'email' should be valid in the request", groups = OnCreate.class)
    @Null(message = "'email' should be absent in the request", groups = OnUpdate.class)
    private String email;

    @ValueOfEnum(enumClass = UserRole.class)
    private UserRole role;

    @NotBlank(message = "'name' shouldn't be absent in the request", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @NotBlank(message = "'surname' shouldn't be absent in the request", groups = {OnCreate.class, OnUpdate.class})
    private String surname;

    @NotBlank(message = "'tel' shouldn't be absent in the request", groups = OnUpdate.class)
    private String tel;

    @Null(message = "'blocked' should be absent in the request", groups = OnCreate.class)
    @NotNull(message = "'blocked' shouldn't be absent in the request", groups = OnUpdate.class)
    private boolean blocked;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ValidPassword(message = "'password' should be valid in the request", groups = OnCreate.class)
    @Null(message = "'password' should be absent in the request", groups = OnUpdate.class)
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Null(message = "'repeatPassword' should be absent in the request", groups = OnUpdate.class)
    private String repeatPassword;

}
