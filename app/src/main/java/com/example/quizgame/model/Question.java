package com.example.quizgame.model;

public class Question {

    public final String questionText;
    public final String choice1;
    public final String choice2;
    public final String choice3;
    public final int answer;

    public Question(String questionText, String choice1, String choice2, String choice3, int answer) {
        this.questionText = questionText;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.answer = answer;
    }
}
