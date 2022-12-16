package com.epam.spring.homework4.repository.impl;

import com.epam.spring.homework4.exception.EntityNotFoundException;
import com.epam.spring.homework4.model.Question;
import com.epam.spring.homework4.repository.QuestionRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Repository
public class QuestionRepositoryImpl implements QuestionRepository {

    private final List<Question> questionList = new ArrayList<>();

    @PostConstruct
    public void initFirstQuestion() {
        Question question = Question.builder()
                .id(1)
                .questionText("This is first question?")
                .build();
        questionList.add(question);
    }

    @Override
    public Question addQuestion(Long testId, Question question) {
        questionList.add(question);
        return question;
    }

    @Override
    public List<Question> getAllQuestions(Long testId) {
        return questionList;
    }

    @Override
    public boolean deleteQuestion(Long questionId) {
        boolean isDeleted = questionList.removeIf(question -> question.getId() == questionId);

        if (!isDeleted) {
            throw new EntityNotFoundException();
        }

        return true;
    }

    @Override
    public Question updateQuestion(Long questionId, Question newQuestion) {
        deleteQuestion(questionId);
        questionList.add(newQuestion);
        return newQuestion;
    }

}
