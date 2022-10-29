package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.*;
import com.epam.spring.homework3.model.User;
import com.epam.spring.homework3.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pavlo Mrochko
 * @since 19.10.2022
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @PostMapping("")
    public TestDTO createTest(TestDTO testDTO) {
        log.info("Creating a new test with id: {}", testDTO.getId());
        return testService.createTest(testDTO);
    }

    @GetMapping("")
    public List<TestDTO> getAllTests(@RequestParam(required = false) String sorting,
                                     @RequestParam(required = false) String subject) {
        log.info("Getting a list of all tests");
        return testService.getAllTests(sorting, subject);
    }

    @DeleteMapping("/{testId}")
    public ResponseEntity<Long> deleteTest(@PathVariable Long testId) {
        log.info("Deleting a test with id: {}", testId);
        boolean isDeleted = testService.deleteTest(testId);

        if (!isDeleted) {
            log.error("Test with id {}, NOT FOUND", testId);
            return new ResponseEntity<>(testId, HttpStatus.NOT_FOUND);
        }

        log.info("Test with id {}, has been successfully deleted", testId);
        return new ResponseEntity<>(testId, HttpStatus.OK);
    }

    @PutMapping("/{testId}")
    public TestDTO updateTest(@PathVariable Long testId, @RequestBody TestDTO testDTO) {
        log.info("Updating a test with id: {}", testId);
        return testService.updateTest(testId, testDTO);
    }

    @PostMapping("/{testId}/start")
    public TestDTO startTest(@SessionAttribute User user, @PathVariable Long testId) {
        log.info("Starting a passing test with id: {}", testId);
        return testService.startTest(user.getId(), testId);
    }

    @PutMapping("/{testId}/submit")
    public HistoryOfTestDTO finishTest(@SessionAttribute User user,
                                       @PathVariable Long testId,
                                       @RequestBody List<AnswersToQuestionDTO> answers) {
        log.info("Finishing a passing test with id: {}", testId);
        return testService.finishTest(user.getId(), testId, answers);
    }

}
