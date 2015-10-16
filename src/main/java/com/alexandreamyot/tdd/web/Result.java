package com.alexandreamyot.tdd.web;

import java.util.List;

public class Result {

    private final int number;
    private final List<Integer> result;

    public Result(int number, List<Integer> result) {
        this.number = number;
        this.result = result;
    }
}
