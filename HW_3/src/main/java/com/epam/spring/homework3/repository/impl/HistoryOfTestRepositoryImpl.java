package com.epam.spring.homework3.repository.impl;

import com.epam.spring.homework3.model.HistoryOfTest;
import com.epam.spring.homework3.repository.HistoryOfTestRepository;
import com.epam.spring.homework3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 25.10.2022
 */
@Repository
@RequiredArgsConstructor
public class HistoryOfTestRepositoryImpl implements HistoryOfTestRepository {

    private final List<HistoryOfTest> records = new ArrayList<>();
    private final UserRepository userRepository;

    @Override
    public HistoryOfTest addRecord(long userId, HistoryOfTest record) {
        record.setStudent(userRepository.findUserByID(userId));

        boolean listContainRecordedThisTest = records.stream()
                .anyMatch(rec -> rec.getTest().getId() == record.getTest().getId());

        if (listContainRecordedThisTest) {
            return updateRecord(userId, record);
        }

        return record;
    }

    @Override
    public HistoryOfTest updateRecord(long userId, HistoryOfTest record) {
        records.removeIf(oldRec -> oldRec.getTest().getId() == record.getTest().getId());
        if (record.getStudent() == null) {
            record.setStudent(userRepository.findUserByID(userId));
        }
        records.add(record);
        return record;
    }

    @Override
    public List<HistoryOfTest> getAllRecords(long userId) {
        return records.stream().filter(r -> r.getStudent().getId() == userId).toList();
    }

}
