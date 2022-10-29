package com.epam.spring.homework3.mapper;

import com.epam.spring.homework3.dto.QuestionDTO;
import com.epam.spring.homework3.dto.TestDTO;
import com.epam.spring.homework3.model.Question;
import com.epam.spring.homework3.model.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 21.10.2022
 */
@Mapper(uses = {AnswerMapper.class})
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionDTO mapToQuestionDTO(Question question);
    Question mapToQuestion(QuestionDTO questionDTO);

    List<Question> mapToListOfQuestions(List<QuestionDTO> questionDTOList);
    List<QuestionDTO> mapToListOfQuestionsDTO(List<Question> questionList);

}
