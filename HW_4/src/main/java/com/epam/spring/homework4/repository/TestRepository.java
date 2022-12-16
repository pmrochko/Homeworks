package com.epam.spring.homework4.repository;

import com.epam.spring.homework4.model.Test;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
public interface TestRepository {

    Test addTest(Test test);

    Test getTestById(long testId);

    List<Test> getAllTests();

    Test updateTest(long testId, Test newTest);

    boolean deleteTest(Long testId);

}
