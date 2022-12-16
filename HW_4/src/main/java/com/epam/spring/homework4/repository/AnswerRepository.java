package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.Answer;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
public interface AnswerRepository {

    Answer addAnswer(Long questionId, Answer answer);

    List<Answer> getAllAnswers(Long questionId);

    boolean deleteAnswer(Long answerId);

    Answer updateAnswer(Long answerId, Answer newAnswer);

}
