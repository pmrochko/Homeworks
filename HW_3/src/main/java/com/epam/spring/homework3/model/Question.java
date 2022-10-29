package com.epam.spring.homework3.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
@Data
@Builder
public class Question {

    private long id;
    private String questionText;
    private List<Answer> answerList;

}
