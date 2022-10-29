package com.epam.spring.homework3.service.impl;

import com.epam.spring.homework3.dto.QuestionDTO;
import com.epam.spring.homework3.mapper.QuestionMapper;
import com.epam.spring.homework3.model.Question;
import com.epam.spring.homework3.repository.QuestionRepository;
import com.epam.spring.homework3.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 23.10.2022
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public QuestionDTO createQuestion(Long testId, QuestionDTO questionDTO) {
        Question question = QuestionMapper.INSTANCE.mapToQuestion(questionDTO);
        question = questionRepository.addQuestion(testId, question);
        log.info("New question was created successfully");
        return QuestionMapper.INSTANCE.mapToQuestionDTO(question);
    }

    @Override
    public List<QuestionDTO> getAllQuestions(Long testId) {
        List<Question> questionList = questionRepository.getAllQuestions(testId);
        log.info("Successful getting a list of questions from the repository");
        return QuestionMapper.INSTANCE.mapToListOfQuestionsDTO(questionList);
    }

    @Override
    public boolean deleteQuestion(Long questionId) {
        boolean result = questionRepository.deleteQuestion(questionId);
        log.info("The question was deleted successfully");
        return result;
    }

    @Override
    public QuestionDTO updateQuestion(Long questionId, QuestionDTO questionDTO) {
        Question question = QuestionMapper.INSTANCE.mapToQuestion(questionDTO);
        question = questionRepository.updateQuestion(questionId, question);
        log.info("The question was updated successfully");
        return QuestionMapper.INSTANCE.mapToQuestionDTO(question);
    }
}
