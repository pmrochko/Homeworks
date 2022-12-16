package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.HistoryOfTest;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
public interface HistoryOfTestRepository {

    HistoryOfTest addRecord(long userId, HistoryOfTest record);

    HistoryOfTest updateRecord(long userId, HistoryOfTest record);

    List<HistoryOfTest> getAllRecords(long userId);

}
