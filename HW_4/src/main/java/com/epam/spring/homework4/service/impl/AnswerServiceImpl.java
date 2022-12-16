package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.AnswerDTO;
import com.epam.spring.homework4.mapper.AnswerMapper;
import com.epam.spring.homework4.model.Answer;
import com.epam.spring.homework4.repository.AnswerRepository;
import com.epam.spring.homework4.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public AnswerDTO createAnswer(Long questionId, AnswerDTO answerDTO) {
        Answer answer = AnswerMapper.INSTANCE.mapToAnswer(answerDTO);
        answer = answerRepository.addAnswer(questionId, answer);
        log.info("New answer was created successfully");
        return AnswerMapper.INSTANCE.mapToAnswerDTO(answer);
    }

    @Override
    public List<AnswerDTO> getAllAnswers(Long questionId) {
        List<Answer> answerList = answerRepository.getAllAnswers(questionId);
        log.info("Successful getting a list of answers from the repository");
        return AnswerMapper.INSTANCE.mapToListOfAnswersDTO(answerList);
    }

    @Override
    public boolean deleteAnswer(Long answerId) {
        boolean result = answerRepository.deleteAnswer(answerId);
        log.info("The answer was deleted successfully");
        return result;
    }

    @Override
    public AnswerDTO updateAnswer(Long answerId, AnswerDTO answerDTO) {
        Answer answer = AnswerMapper.INSTANCE.mapToAnswer(answerDTO);
        answer = answerRepository.updateAnswer(answerId, answer);
        log.info("The answer was updated successfully");
        return AnswerMapper.INSTANCE.mapToAnswerDTO(answer);
    }

}
