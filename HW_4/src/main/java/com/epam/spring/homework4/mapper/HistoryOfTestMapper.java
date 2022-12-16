package com.epam.spring.homework4.mapper;

import com.epam.spring.homework4.dto.HistoryOfTestDTO;
import com.epam.spring.homework4.model.HistoryOfTest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Mapper
public interface HistoryOfTestMapper {

    HistoryOfTestMapper INSTANCE = Mappers.getMapper(HistoryOfTestMapper.class);

    HistoryOfTest mapToHistoryOfTest(HistoryOfTestDTO historyOfTestDTO);
    HistoryOfTestDTO mapToHistoryOfTestDTO(HistoryOfTest historyOfTest);

    List<HistoryOfTestDTO> mapToListDTO(List<HistoryOfTest> historyOfTestList);

}
