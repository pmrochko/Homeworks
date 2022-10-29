package com.epam.spring.homework3.model;

import com.epam.spring.homework3.model.enums.AnswerStatus;
import lombok.Builder;
import lombok.Data;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
@Data
@Builder
public class Answer {

    private long id;
    private AnswerStatus answerStatus;
    private String answerText;

}
