package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.Answer;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
public interface AnswerRepository {

    Answer addAnswer(Long questionId, Answer answer);

    List<Answer> getAllAnswers(Long questionId);

    boolean deleteAnswer(Long answerId);

    Answer updateAnswer(Long answerId, Answer newAnswer);

}
