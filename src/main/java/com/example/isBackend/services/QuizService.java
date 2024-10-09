package com.example.isBackend.services;

import com.example.isBackend.models.QuizCategory;
import com.example.isBackend.models.QuizQuestion;
import com.example.isBackend.payload.QuizAnswerRequest;
import com.example.isBackend.repository.QuizQuestionRepository;
import com.example.isBackend.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository categoryRepository;


    private final QuizQuestionRepository questionRepository;

    public List<QuizCategory> getCategories() {
        return categoryRepository.findAll();
    }

    public List<QuizQuestion> getQuestions(Long categoryId) {
        return questionRepository.findByCategoryId(categoryId);
    }

     // Soumettre les réponses du quiz et calculer le score
    public Long submitQuiz(List<QuizAnswerRequest> userAnswers) {
         long score = 0;

        for (QuizAnswerRequest answerRequest : userAnswers) {
            Optional<QuizQuestion> questionOptional = questionRepository.findById(answerRequest.getQuestionId());

            if (questionOptional.isPresent()) {
                QuizQuestion question = questionOptional.get();

                if (question.getAnswer().equalsIgnoreCase(answerRequest.getUserAnswer())) {
                    score++;
                }
            }
        }

        return score;
    }
}
