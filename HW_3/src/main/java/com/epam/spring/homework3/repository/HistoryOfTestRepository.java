package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.HistoryOfTest;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 25.10.2022
 */
public interface HistoryOfTestRepository {

    HistoryOfTest addRecord(long userId, HistoryOfTest record);

    HistoryOfTest updateRecord(long userId, HistoryOfTest record);

    List<HistoryOfTest> getAllRecords(long userId);

}
