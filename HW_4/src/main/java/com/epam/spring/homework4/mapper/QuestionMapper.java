package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.QuestionDTO;
import com.epam.spring.homework4.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Mapper(uses = {AnswerMapper.class})
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionDTO mapToQuestionDTO(Question question);
    Question mapToQuestion(QuestionDTO questionDTO);

    List<Question> mapToListOfQuestions(List<QuestionDTO> questionDTOList);
    List<QuestionDTO> mapToListOfQuestionsDTO(List<Question> questionList);

}
