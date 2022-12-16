package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.*;
import com.epam.spring.homework4.model.User;
import com.epam.spring.homework4.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @PostMapping("")
    public TestDTO createTest(@Valid TestDTO testDTO) {
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
    public ResponseEntity<Long> deleteTest(@Positive @PathVariable Long testId) {
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
    public TestDTO updateTest(@Positive @PathVariable Long testId, @Valid @RequestBody TestDTO testDTO) {
        log.info("Updating a test with id: {}", testId);
        return testService.updateTest(testId, testDTO);
    }

    @PostMapping("/{testId}/start")
    public TestDTO startTest(@SessionAttribute UserDTO user, @PathVariable Long testId) {
        log.info("Starting a passing test with id: {}", testId);
        return testService.startTest(user.getId(), testId);
    }

    @PutMapping("/{testId}/submit")
    public HistoryOfTestDTO finishTest(@SessionAttribute UserDTO user,
                                       @Positive @PathVariable Long testId,
                                       @Valid @RequestBody List<AnswersToQuestionDTO> answers) {
        log.info("Finishing a passing test with id: {}", testId);
        return testService.finishTest(user.getId(), testId, answers);
    }

}
