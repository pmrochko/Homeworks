package com.epam.spring.homework4.dto;

import com.epam.spring.homework4.model.Subject;
import com.epam.spring.homework4.model.enums.TestDifficulty;
import com.epam.spring.homework4.validation.ValueOfEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Data
@Builder
public class TestDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotBlank
    private Subject subject;

    @NotBlank
    private String title;

    private String description;

    @ValueOfEnum(enumClass = TestDifficulty.class)
    private TestDifficulty difficulty;

    @Positive
    private int minutes;

    private List<QuestionDTO> questionList;

}
