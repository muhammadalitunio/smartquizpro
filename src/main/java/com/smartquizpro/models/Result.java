package com.smartquizpro.models;

public class Result {


    private String studentName;
    private int score;

    public Result(String studentName, int score) {

        this.studentName = studentName;
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getScore() {
        return score;
    }
}
