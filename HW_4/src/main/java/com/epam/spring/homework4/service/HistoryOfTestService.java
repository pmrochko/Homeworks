package com.epam.spring.homework4.service;

import com.epam.spring.homework4.dto.HistoryOfTestDTO;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
public interface HistoryOfTestService {

    HistoryOfTestDTO createHistoryOfTest(long userId, HistoryOfTestDTO historyOfTestDTO);

    List<HistoryOfTestDTO> getHistoryOfTests(long userId);

}
