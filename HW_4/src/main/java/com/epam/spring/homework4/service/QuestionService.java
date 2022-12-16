package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.QuestionDTO;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
public interface QuestionService {

    QuestionDTO createQuestion(Long testId, QuestionDTO questionDTO);

    List<QuestionDTO> getAllQuestions(Long testId);

    boolean deleteQuestion(Long questionId);

    QuestionDTO updateQuestion(Long questionId, QuestionDTO questionDTO);

}
