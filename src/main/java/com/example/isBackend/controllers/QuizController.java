package com.example.isBackend.controllers;


import com.example.isBackend.models.QuizCategory;
import com.example.isBackend.models.QuizQuestion;
import com.example.isBackend.payload.QuizAnswerRequest;
import com.example.isBackend.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/islamic/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/categories")
    public List<QuizCategory> getCategories() {
        return quizService.getCategories();
    }

    @GetMapping("/categories/{categoryId}/questions")
    public List<QuizQuestion> getQuestions(@PathVariable Long categoryId) {
        return quizService.getQuestions(categoryId);
    }

    @PostMapping("/submit")
    public Long submitQuiz(@RequestBody List<QuizAnswerRequest> userAnswers) {
        return quizService.submitQuiz(userAnswers);
    }
}
