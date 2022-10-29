package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.AnswerDTO;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
public interface AnswerService {

    AnswerDTO createAnswer(Long questionId, AnswerDTO answerDTO);

    List<AnswerDTO> getAllAnswers(Long questionId);

    boolean deleteAnswer(Long answerId);

    AnswerDTO updateAnswer(Long answerId, AnswerDTO answerDTO);

}
