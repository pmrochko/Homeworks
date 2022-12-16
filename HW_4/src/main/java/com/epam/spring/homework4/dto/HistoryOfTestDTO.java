package com.epam.spring.homework4.dto;

import com.epam.spring.homework4.model.Test;
import com.epam.spring.homework4.model.User;
import com.epam.spring.homework4.model.enums.TestDifficulty;
import com.epam.spring.homework4.model.enums.TestProgressStatus;
import com.epam.spring.homework4.validation.ValueOfEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.sql.Timestamp;

/**
 * @author Pavlo Mrochko
 */
@Data
@Builder
public class HistoryOfTestDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private long id;

    @NotNull
    private User student;

    @NotNull
    private Test test;

    @NotNull
    private Timestamp completionTime;

    @ValueOfEnum(enumClass = TestProgressStatus.class)
    private TestProgressStatus status;

    @PositiveOrZero
    private long resultInPercent;

}
