package com.epam.spring.homework4.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Data
@Builder
public class Question {

    private long id;
    private String questionText;
    private List<Answer> answerList;

}
