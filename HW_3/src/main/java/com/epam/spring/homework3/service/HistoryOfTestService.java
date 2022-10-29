package com.epam.spring.homework3.service;

import com.epam.spring.homework3.dto.HistoryOfTestDTO;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 25.10.2022
 */
public interface HistoryOfTestService {

    HistoryOfTestDTO createHistoryOfTest(long userId, HistoryOfTestDTO historyOfTestDTO);

    List<HistoryOfTestDTO> getHistoryOfTests(long userId);

}
