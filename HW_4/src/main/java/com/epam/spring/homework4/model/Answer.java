package com.epam.spring.homework4.model;

import com.epam.spring.homework4.model.enums.AnswerStatus;
import lombok.Builder;
import lombok.Data;

/**
 * @author Pavlo Mrochko
 */
@Data
@Builder
public class Answer {

    private long id;
    private AnswerStatus answerStatus;
    private String answerText;

}
