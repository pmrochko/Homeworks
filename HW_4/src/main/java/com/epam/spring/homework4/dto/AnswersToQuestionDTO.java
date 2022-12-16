package com.epam.spring.homework4.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Data
public class AnswersToQuestionDTO {

    @NotNull
    private QuestionDTO questionDTO;

    @NotNull
    private List<AnswerDTO> selectedAnswersDTO;

}
