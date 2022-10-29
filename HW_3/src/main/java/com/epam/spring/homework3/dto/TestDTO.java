package com.epam.spring.homework3.dto;

import com.epam.spring.homework3.model.Subject;
import com.epam.spring.homework3.model.enums.TestDifficulty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
@Data
@Builder
public class TestDTO {

    private long id;
    private Subject subject;
    private String title;
    private String description;
    private TestDifficulty difficulty;
    private int minutes;
    private List<QuestionDTO> questionList;

}
