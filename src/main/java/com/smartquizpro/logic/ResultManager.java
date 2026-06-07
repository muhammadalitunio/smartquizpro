package com.smartquizpro.logic;

import java.util.ArrayList;

import com.smartquizpro.models.Result;

public class ResultManager {

    private ArrayList<Result> results;

    public ResultManager() {

        results = new ArrayList<>();
    }

    public void addResult(Result result) {

        results.add(result);
    }

    public ArrayList<Result> getResults() {

        return results;
    }
}