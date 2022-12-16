package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.AnswersToQuestionDTO;
import com.epam.spring.homework4.dto.HistoryOfTestDTO;
import com.epam.spring.homework4.dto.TestDTO;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
public interface TestService {

    TestDTO createTest(TestDTO testDTO);

    List<TestDTO> getAllTests(String sorting, String subject);

    boolean deleteTest(long testId);

    TestDTO updateTest(long testId, TestDTO testDTO);

    TestDTO startTest(long userId, long testId);

    HistoryOfTestDTO finishTest(long userId, long testId, List<AnswersToQuestionDTO> selectedAnswers);

}
