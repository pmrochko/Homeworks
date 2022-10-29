package com.epam.spring.homework3.dto;

import com.epam.spring.homework3.model.Test;
import com.epam.spring.homework3.model.User;
import com.epam.spring.homework3.model.enums.TestProgressStatus;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Pavlo Mrochko
 * @since 25.10.2022
 */
@Data
@Builder
public class HistoryOfTestDTO {

    private long id;
    private User student;
    private Test test;
    private Timestamp completionTime;
    private TestProgressStatus status;
    private long resultInPercent;

}
