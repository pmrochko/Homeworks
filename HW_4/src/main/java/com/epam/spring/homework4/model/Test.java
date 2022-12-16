package com.epam.spring.homework4.model;

import com.epam.spring.homework4.model.enums.TestDifficulty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Data
@Builder
public class Test {

    private long id;
    private Subject subject;
    private String title;
    private String description;
    private TestDifficulty difficulty;
    private int minutes;
    private List<Question> questionList;

}
