package com.example.isBackend.payload;

public class QuizAnswerRequest {

    private Long questionId;
    private String userAnswer;

    // Getters et setters
    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
