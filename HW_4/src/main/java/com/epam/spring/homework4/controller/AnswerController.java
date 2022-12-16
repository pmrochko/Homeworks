package com.epam.spring.homework4.controller;

import com.epam.spring.homework4.dto.AnswerDTO;
import com.epam.spring.homework4.service.AnswerService;
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
@RequestMapping("/test/question")
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/{questionId}/answer")
    public AnswerDTO createAnswerForQuestion(@Positive @PathVariable Long questionId,
                                             @Valid @RequestBody AnswerDTO answerDTO) {
        log.info("Creating a new answer for a question with id: {}", questionId);
        return answerService.createAnswer(questionId, answerDTO);
    }

    @GetMapping("/{questionId}/answer")
    public List<AnswerDTO> getAllAnswersForQuestion(@Positive @PathVariable Long questionId) {
        log.info("Getting all answer for a question with id: {}", questionId);
        return answerService.getAllAnswers(questionId);
    }

    @DeleteMapping("/answer/{answerId}")
    public ResponseEntity<Long> deleteAnswer(@Positive @PathVariable Long answerId) {
        log.info("Deleting a answer with id: {}", answerId);
        boolean isDeleted = answerService.deleteAnswer(answerId);

        if (!isDeleted) {
            log.error("Answer with id {}, NOT FOUND", answerId);
            return new ResponseEntity<>(answerId, HttpStatus.NOT_FOUND);
        }

        log.info("Answer with id {}, has been successfully deleted", answerId);
        return new ResponseEntity<>(answerId, HttpStatus.OK);
    }

    @PutMapping("/answer/{answerId}")
    public AnswerDTO updateAnswer(@Positive @PathVariable Long answerId,
                                  @Valid @RequestBody AnswerDTO answerDTO) {
        log.info("Updating a answer with id: {}", answerDTO);
        return answerService.updateAnswer(answerId, answerDTO);
    }

}
