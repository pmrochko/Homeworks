package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.AnswerDTO;
import com.epam.spring.homework4.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Mapper
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    AnswerDTO mapToAnswerDTO(Answer answer);
    Answer mapToAnswer(AnswerDTO answerDTO);

    List<Answer> mapToListOfAnswers(List<AnswerDTO> answerDTOList);
    List<AnswerDTO> mapToListOfAnswersDTO(List<Answer> answerList);

}
