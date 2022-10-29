package com.epam.spring.homework3.repository;

import com.epam.spring.homework3.model.Test;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
public interface TestRepository {

    Test addTest(Test test);

    Test getTestById(long testId);

    List<Test> getAllTests();

    Test updateTest(long testId, Test newTest);

    boolean deleteTest(Long testId);

}
