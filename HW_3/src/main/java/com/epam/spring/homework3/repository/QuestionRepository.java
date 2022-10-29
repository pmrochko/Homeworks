package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.Question;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
public interface QuestionRepository {

    Question addQuestion(Long testId, Question question);

    List<Question> getAllQuestions(Long testId);

    boolean deleteQuestion(Long questionId);

    Question updateQuestion(Long questionId, Question newQuestion);

}
