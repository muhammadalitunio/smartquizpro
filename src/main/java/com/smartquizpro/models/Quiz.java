package com.smartquizpro.models;

import java.util.ArrayList;

public class Quiz {
        private String title;

    private ArrayList<Question> questions;

    public Quiz(String title) {

        this.title = title;

        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
    public Question getQuestion(int index) {
        return questions.get(index);

    }
    public int getTotalQuestions() {
        return questions.size();

    }
}
