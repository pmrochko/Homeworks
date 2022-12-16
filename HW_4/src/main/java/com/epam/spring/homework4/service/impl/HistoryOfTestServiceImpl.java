package com.epam.spring.homework4.service.impl;

import com.epam.spring.homework4.dto.HistoryOfTestDTO;
import com.epam.spring.homework4.mapper.HistoryOfTestMapper;
import com.epam.spring.homework4.model.HistoryOfTest;
import com.epam.spring.homework4.repository.HistoryOfTestRepository;
import com.epam.spring.homework4.service.HistoryOfTestService;
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
public class HistoryOfTestServiceImpl implements HistoryOfTestService {

    private final HistoryOfTestRepository historyOfTestRepository;

    @Override
    public HistoryOfTestDTO createHistoryOfTest(long userId, HistoryOfTestDTO historyOfTestDTO) {
        HistoryOfTest record = HistoryOfTestMapper.INSTANCE.mapToHistoryOfTest(historyOfTestDTO);
        record = historyOfTestRepository.addRecord(userId, record);
        log.info("The history of test record was created successfully");
        return HistoryOfTestMapper.INSTANCE.mapToHistoryOfTestDTO(record);
    }

    @Override
    public List<HistoryOfTestDTO> getHistoryOfTests(long userId) {
        List<HistoryOfTest> records = historyOfTestRepository.getAllRecords(userId);
        log.info("All history of tests for the user was getting from repository successfully");
        return HistoryOfTestMapper.INSTANCE.mapToListDTO(records);
    }

}
