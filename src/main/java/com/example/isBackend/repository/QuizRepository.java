package com.example.isBackend.repository;

import com.example.isBackend.models.QuizCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizCategory, Long> {
}
