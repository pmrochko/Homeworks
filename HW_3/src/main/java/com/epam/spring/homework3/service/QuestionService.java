package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.QuestionDTO;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
public interface QuestionService {

    QuestionDTO createQuestion(Long testId, QuestionDTO questionDTO);

    List<QuestionDTO> getAllQuestions(Long testId);

    boolean deleteQuestion(Long questionId);

    QuestionDTO updateQuestion(Long questionId, QuestionDTO questionDTO);

}
