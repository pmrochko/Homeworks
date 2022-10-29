package com.epam.spring.homework3.mapper;

import com.epam.spring.homework3.dto.HistoryOfTestDTO;
import com.epam.spring.homework3.dto.TestDTO;
import com.epam.spring.homework3.model.HistoryOfTest;
import com.epam.spring.homework3.model.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 25.10.2022
 */
@Mapper
public interface HistoryOfTestMapper {

    HistoryOfTestMapper INSTANCE = Mappers.getMapper(HistoryOfTestMapper.class);

    HistoryOfTest mapToHistoryOfTest(HistoryOfTestDTO historyOfTestDTO);
    HistoryOfTestDTO mapToHistoryOfTestDTO(HistoryOfTest historyOfTest);

    List<HistoryOfTestDTO> mapToListDTO(List<HistoryOfTest> historyOfTestList);

}
