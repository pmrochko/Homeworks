package com.epam.spring.homework3.controller;

import com.epam.spring.homework3.dto.QuestionDTO;
import com.epam.spring.homework3.service.QuestionService;
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
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/{testId}/question")
    public QuestionDTO createQuestionForTest(@PathVariable Long testId, @RequestBody QuestionDTO questionDTO) {
        log.info("Creating a new question for a test with id: {}", testId);
        return questionService.createQuestion(testId, questionDTO);
    }

    @GetMapping("/{testId}/question")
    public List<QuestionDTO> getAllQuestionsForTest(@PathVariable Long testId) {
        log.info("Getting all questions for a test with id: {}", testId);
        return questionService.getAllQuestions(testId);
    }

    @DeleteMapping("/question/{questionId}")
    public ResponseEntity<Long> deleteQuestion(@PathVariable Long questionId) {
        log.info("Deleting a question with id: {}", questionId);
        boolean isDeleted = questionService.deleteQuestion(questionId);

        if (!isDeleted) {
            log.error("Question with id {}, NOT FOUND", questionId);
            return new ResponseEntity<>(questionId, HttpStatus.NOT_FOUND);
        }

        log.info("Question with id {}, has been successfully deleted", questionId);
        return new ResponseEntity<>(questionId, HttpStatus.OK);
    }

    @PutMapping("/question/{questionId}")
    public QuestionDTO updateQuestion(@PathVariable Long questionId, @RequestBody QuestionDTO questionDTO) {
        log.info("Updating a question with id: {}", questionDTO);
        return questionService.updateQuestion(questionId, questionDTO);
    }

}
