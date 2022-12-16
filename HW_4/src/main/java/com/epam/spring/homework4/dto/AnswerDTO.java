package com.epam.spring.homework4.dto;

import com.epam.spring.homework4.model.enums.AnswerStatus;
import com.epam.spring.homework4.validation.ValueOfEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Pavlo Mrochko
 */
@Data
@Builder
public class AnswerDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @ValueOfEnum(enumClass = AnswerStatus.class)
    private AnswerStatus answerStatus;

    @NotBlank
    private String answerText;

}
