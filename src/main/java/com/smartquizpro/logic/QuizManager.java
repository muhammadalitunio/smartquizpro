package com.smartquizpro.logic;

import java.util.ArrayList;

import com.smartquizpro.models.Quiz;

public class QuizManager {

    private static ArrayList<Quiz> quizzes =
            new ArrayList<>();
            
    private static Quiz currentQuiz;

    public void addQuiz(Quiz quiz) {

        quizzes.add(quiz);

    }

    public ArrayList<Quiz> getQuizzes() {

        return quizzes;

    }
    public void setCurrentQuiz(Quiz quiz) {

        currentQuiz = quiz;

    }

    public Quiz getCurrentQuiz() {

        return currentQuiz;
}
}