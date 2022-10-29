package com.epam.spring.homework3.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 26.10.2022
 */
@Data
public class AnswersToQuestionDTO {

    private QuestionDTO questionDTO;
    private List<AnswerDTO> selectedAnswersDTO;

}
