package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.model.Answer;
import com.epam.spring.homework3.model.Question;
import com.epam.spring.homework3.model.Subject;
import com.epam.spring.homework3.model.Test;
import com.epam.spring.homework3.model.enums.AnswerStatus;
import com.epam.spring.homework3.model.enums.TestDifficulty;
import com.epam.spring.homework3.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 21.10.2022
 */
@Repository
public class TestRepositoryImpl implements TestRepository {

    private final List<Test> testList = new ArrayList<>();

    @PostConstruct
    public void initFirstTest() {
        Test test = Test.builder()
                .id(1)
                .title("ExampleTitle")
                .description("First Test")
                .subject(new Subject(1, "ExampleSubject"))
                .difficulty(TestDifficulty.EASY)
                .minutes(20)
                .questionList(initQuestions())
                .build();
        testList.add(test);
    }

    private List<Question> initQuestions() {
        List<Question> questionList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            questionList.add(Question.builder()
                    .id(i)
                    .questionText("Question #" + i)
                    .answerList(initAnswers())
                    .build());
        }
        return questionList;
    }

    private List<Answer> initAnswers() {
        List<Answer> answerList = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            answerList.add(Answer.builder()
                    .id(i)
                    .answerText("Answer #" + i)
                    .answerStatus(i % 2 == 0 ? AnswerStatus.RIGHT : AnswerStatus.WRONG)
                    .build());
        }
        return answerList;
    }

    @Override
    public Test addTest(Test test) {
        testList.add(test);
        return test;
    }

    @Override
    public Test getTestById(long testId) {
        return testList.stream()
                .filter(test -> test.getId() == testId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Test is not found"));
    }

    @Override
    public List<Test> getAllTests() {
        return testList;
    }

    @Override
    public Test updateTest(long testId, Test newTest) {
        deleteTest(testId);
        testList.add(newTest);
        return newTest;
    }

    @Override
    public boolean deleteTest(Long testId) {
        boolean isDeleted = testList.removeIf(test -> test.getId() == testId);

        if (!isDeleted) {
            throw new RuntimeException("Test is not found");
        }

        return true;
    }

}
