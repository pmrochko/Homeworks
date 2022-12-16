package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.Question;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
public interface QuestionRepository {

    Question addQuestion(Long testId, Question question);

    List<Question> getAllQuestions(Long testId);

    boolean deleteQuestion(Long questionId);

    Question updateQuestion(Long questionId, Question newQuestion);

}
