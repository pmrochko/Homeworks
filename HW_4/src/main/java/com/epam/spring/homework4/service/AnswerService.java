package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.AnswerDTO;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
public interface AnswerService {

    AnswerDTO createAnswer(Long questionId, AnswerDTO answerDTO);

    List<AnswerDTO> getAllAnswers(Long questionId);

    boolean deleteAnswer(Long answerId);

    AnswerDTO updateAnswer(Long answerId, AnswerDTO answerDTO);

}
