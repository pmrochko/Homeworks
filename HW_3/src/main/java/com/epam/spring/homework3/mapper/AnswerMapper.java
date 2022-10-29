package com.epam.spring.homework3.mapper;

import com.epam.spring.homework3.dto.AnswerDTO;
import com.epam.spring.homework3.dto.QuestionDTO;
import com.epam.spring.homework3.model.Answer;
import com.epam.spring.homework3.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 21.10.2022
 */
@Mapper
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    AnswerDTO mapToAnswerDTO(Answer answer);
    Answer mapToAnswer(AnswerDTO answerDTO);

    List<Answer> mapToListOfAnswers(List<AnswerDTO> answerDTOList);
    List<AnswerDTO> mapToListOfAnswersDTO(List<Answer> answerList);

}
