package com.epam.spring.homework4.repository.impl;

import com.epam.spring.homework4.model.Answer;
import com.epam.spring.homework4.model.enums.AnswerStatus;
import com.epam.spring.homework4.repository.AnswerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Repository
@Slf4j
public class AnswerRepositoryImpl implements AnswerRepository {

    private final List<Answer> answerList = new ArrayList<>();

    @PostConstruct
    public void initFirstAnswer() {
        Answer answer = Answer.builder()
                .id(1)
                .answerStatus(AnswerStatus.WRONG)
                .answerText("First Answer")
                .build();
        answerList.add(answer);
    }

    @Override
    public Answer addAnswer(Long questionId, Answer answer) {
        answerList.add(answer);
        return answer;
    }

    @Override
    public List<Answer> getAllAnswers(Long questionId) {
        return answerList;
    }

    @Override
    public boolean deleteAnswer(Long answerId) {
        boolean isDeleted = answerList.removeIf(answer -> answer.getId() == answerId);

        if (!isDeleted) {
            throw new RuntimeException("Answer is not found");
        }

        return true;
    }

    @Override
    public Answer updateAnswer(Long answerId, Answer newAnswer) {
        deleteAnswer(answerId);
        answerList.add(newAnswer);
        return newAnswer;
    }

}
