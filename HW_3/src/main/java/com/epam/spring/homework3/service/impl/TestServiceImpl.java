package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.AnswersToQuestionDTO;
import com.epam.spring.homework3.dto.HistoryOfTestDTO;
import com.epam.spring.homework3.dto.TestDTO;
import com.epam.spring.homework3.mapper.AnswerMapper;
import com.epam.spring.homework3.mapper.HistoryOfTestMapper;
import com.epam.spring.homework3.mapper.QuestionMapper;
import com.epam.spring.homework3.mapper.TestMapper;
import com.epam.spring.homework3.model.Answer;
import com.epam.spring.homework3.model.HistoryOfTest;
import com.epam.spring.homework3.model.Question;
import com.epam.spring.homework3.model.Test;
import com.epam.spring.homework3.model.enums.AnswerStatus;
import com.epam.spring.homework3.model.enums.TestProgressStatus;
import com.epam.spring.homework3.repository.HistoryOfTestRepository;
import com.epam.spring.homework3.repository.TestRepository;
import com.epam.spring.homework3.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pavlo Mrochko
 * @since 21.10.2022
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;
    private final HistoryOfTestRepository historyRepository;

    @Override
    public TestDTO createTest(TestDTO testDTO) {
        Test test = TestMapper.INSTANCE.mapToTest(testDTO);
        test = testRepository.addTest(test);
        log.info("New test was created successfully");
        return TestMapper.INSTANCE.mapToTestDTO(test);
    }

    @Override
    public List<TestDTO> getAllTests(String sorting, String subject) {
        List<Test> testList = testRepository.getAllTests();

        if (subject != null) {
            testList = testList.stream()
                    .filter(t -> t.getSubject().getName().equals(subject))
                    .collect(Collectors.toList());
        }

        log.info("Successful getting a list of tests from the repository");
        return TestMapper.INSTANCE.mapToListOfTestsDTO(testList);
    }

    @Override
    public boolean deleteTest(long testId) {
        boolean result = testRepository.deleteTest(testId);
        log.info("The test was deleted successfully");
        return result;
    }

    @Override
    public TestDTO updateTest(long testId, TestDTO testDTO) {
        Test test = TestMapper.INSTANCE.mapToTest(testDTO);
        test = testRepository.updateTest(testId, test);
        log.info("The test was updated successfully");
        return TestMapper.INSTANCE.mapToTestDTO(test);
    }

    @Override
    public TestDTO startTest(long userId, long testId) {
        Test test = testRepository.getTestById(testId);
        HistoryOfTest record = HistoryOfTest.builder()
                .test(test)
                .completionTime(new Timestamp(System.currentTimeMillis()))
                .resultInPercent(0)
                .status(TestProgressStatus.STARTED)
                .build();
        historyRepository.addRecord(userId, record);
        log.info("The test was started successfully");
        return TestMapper.INSTANCE.mapToTestDTO(test);
    }

    @Override
    public HistoryOfTestDTO finishTest(long userId, long testId,
                                       List<AnswersToQuestionDTO> selectedAnswersToQuestions) {
        Test test = testRepository.getTestById(testId);
        long result = calculateResult(test, selectedAnswersToQuestions);
        HistoryOfTest record = HistoryOfTest.builder()
                .test(test)
                .completionTime(new Timestamp(System.currentTimeMillis()))
                .resultInPercent(result)
                .status(TestProgressStatus.FINISHED)
                .build();
        historyRepository.addRecord(userId, record);
        log.info("The test was finished successfully");
        return HistoryOfTestMapper.INSTANCE.mapToHistoryOfTestDTO(record);
    }

    private long calculateResult(Test test, List<AnswersToQuestionDTO> selectedAnswersToQuestions) {

        int countOfCorrectChoices = 0;

        for (AnswersToQuestionDTO choice : selectedAnswersToQuestions) {
            if (isCorrectSelectedAnswer(choice))
                countOfCorrectChoices++;
        }

        int countOfQuestionsInTest = test.getQuestionList().size();
        long result = Math.round(countOfCorrectChoices * 100.0 / countOfQuestionsInTest);
        log.info("Calculating result of test was done successful with score: {}%", result);
        return result;
    }

    private boolean isCorrectSelectedAnswer(AnswersToQuestionDTO selectedAnswer) {

        Question question = QuestionMapper.INSTANCE.mapToQuestion(selectedAnswer.getQuestionDTO());
        List<Answer> rightAnswersInQuestion = filterRightAnswers(question.getAnswerList());

        List<Answer> allSelectedAnswers = AnswerMapper.INSTANCE.mapToListOfAnswers(selectedAnswer.getSelectedAnswersDTO());
        List<Answer> rightSelectedAnswers = filterRightAnswers(allSelectedAnswers);

        return rightAnswersInQuestion.equals(rightSelectedAnswers);

    }

    private List<Answer> filterRightAnswers(List<Answer> allAnswers) {
        return allAnswers.stream()
                .filter(answer -> answer.getAnswerStatus().equals(AnswerStatus.RIGHT))
                .toList();
    }

}
