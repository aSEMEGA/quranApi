package com.example.isBackend.repository;

import com.example.isBackend.models.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {

    List<QuizQuestion> findByCategoryId(Long categoryId);
}
