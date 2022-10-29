package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.AnswersToQuestionDTO;
import com.epam.spring.homework3.dto.HistoryOfTestDTO;
import com.epam.spring.homework3.dto.TestDTO;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
public interface TestService {

    TestDTO createTest(TestDTO testDTO);

    List<TestDTO> getAllTests(String sorting, String subject);

    boolean deleteTest(long testId);

    TestDTO updateTest(long testId, TestDTO testDTO);

    TestDTO startTest(long userId, long testId);

    HistoryOfTestDTO finishTest(long userId, long testId, List<AnswersToQuestionDTO> selectedAnswers);

}
