package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.TestDTO;
import com.epam.spring.homework4.model.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Mapper(uses = {QuestionMapper.class})
public interface TestMapper {

    TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

    TestDTO mapToTestDTO(Test test);

    Test mapToTest(TestDTO testDTO);

    List<TestDTO> mapToListOfTestsDTO(List<Test> testList);

}
