package com.epam.spring.homework4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Data
@Builder
public class QuestionDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotBlank
    private String questionText;

    private List<AnswerDTO> answerList;

}
